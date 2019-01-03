/**
 * Date:     2018/12/3116:31
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.netty.handler;

import com.zhou.weichat.model.ChatSession;
import com.zhou.weichat.model.en.ChatStatus;
import com.zhou.weichat.netty.ChannelSession;
import com.zhou.weichat.netty.constant.AttributeKeyConst;
import com.zhou.weichat.netty.utils.ChannelManager;
import com.zhou.weichat.service.ChatSessionService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * 2018/12/31  16:31
 * created by zhoumb
 */
@Component
public class NettySocketServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger logger = LoggerFactory.getLogger(NettySocketServerHandler.class);

    @Autowired
    private ChatSessionService chatSessionService;

    /**
     * Handler 加入处理
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        logger.info(" nettySocketServerHandler handlerAdded , 注册 channelId:{}" + ctx.channel().id().asLongText());
        super.handlerAdded(ctx);
    }

    /**
     * channel在链路中激活
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("nettySocketServerHandler channelActive , clientIp:{}", ctx.channel().remoteAddress().toString());
        //设置session 属性
        ctx.channel().attr(AttributeKeyConst.SESSION).set(new ChannelSession(ctx.channel()));
        logger.info("nettySocketServerHandler -> channelActive  client={} connect to Netty Server ... ");
        //find or create chat session
        ChannelSession channelSession = ctx.channel().attr(AttributeKeyConst.SESSION).get();
        ChatSession chatSession = chatSessionService.findOrCreateSession(channelSession,ChatStatus.LOGIN);
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress socketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIP = socketAddress.getAddress().getHostAddress();
        logger.info("client={} close connection ... ChannelSize={}", clientIP, ChannelManager.getChannelSessionSize());

        ChannelSession channelSession = ctx.channel().attr(AttributeKeyConst.SESSION).get();
        if (channelSession != null && StringUtils.isNotBlank(channelSession.getUserId())) {
            ChannelManager.removeChannelSession(channelSession.getUserId());

        }
        super.channelInactive(ctx);
    }

    /**
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

    }
}
