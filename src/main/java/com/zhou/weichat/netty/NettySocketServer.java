/**
 * Date:     2018/12/2822:23
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.netty;

import com.zhou.weichat.netty.handler.NettySocketServerHandler;
import com.zhou.weichat.netty.proto.MessageDecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * netty socket server 对象定义
 * 2018/12/28  22:23
 * created by zhoumb
 */
@Component
public class NettySocketServer {

    @Qualifier(value = "boss")
    @Autowired
    private NioEventLoopGroup boss;
    @Qualifier(value = "worker")
    @Autowired
    private NioEventLoopGroup worker;

    @Autowired
    private NettySocketProperties nettySocketProperties;


    public void startNettySocketServer() {
        int port = getPort();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                /* .option(ChannelOption.SO_BACKLOG, 2000)
                 .option(ChannelOption.SO_REUSEADDR, true)
                 .option(ChannelOption.SO_RCVBUF, 256 * 1024)
                 .option(ChannelOption.SO_SNDBUF, 256 * 1024)
                 .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                 .childOption(ChannelOption.SO_KEEPALIVE, true)
                 .childOption(ChannelOption.SO_KEEPALIVE, true)
                 .childOption(ChannelOption.TCP_NODELAY, true)
                 .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                 .childOption(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT)*/
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new NettySocketServerInitializer());


    }

    /**
     * 获取设置的netty socket server 监听的端口 没有设置则使用默认的端口
     */
    private static final int DEFAULT_PORT = 9000;

    private int getPort() {
        return nettySocketProperties.getPort() > 0 ? nettySocketProperties.getPort() : DEFAULT_PORT;
    }

    private class NettySocketServerInitializer extends ChannelInitializer {
        @Override
        protected void initChannel(Channel ch) throws Exception {
//            ch.pipeline().addLast(new MessageDecoder());
            //设置空闲时间
            ch.pipeline().addLast(new IdleStateHandler(30, 0, 60));
            //httpServerCodec: 将请求和应答消息解码为HTTP消息
            ch.pipeline().addLast(new HttpServerCodec());
            //针对大文件上传，定义可接受的数据大小为64M
            ch.pipeline().addLast(new HttpObjectAggregator(64 * 1024));
            //针对大文件下发，分块写数据
            ch.pipeline().addLast(new ChunkedWriteHandler());
            //自定义 handler
            ch.pipeline().addLast(new NettySocketServerHandler());
        }
    }
}
