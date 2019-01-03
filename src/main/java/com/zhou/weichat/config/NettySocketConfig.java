/**
 * Date:     2018/12/2822:34
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.config;

import com.zhou.weichat.netty.NettySocketProperties;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 2018/12/28  22:34
 * created by zhoumb
 */
@Component
@Configuration
public class NettySocketConfig {
    @Autowired
    private NettySocketProperties nettySocketProperties;

    @Bean(name = "boss")
    public NioEventLoopGroup getBoss() {
        return nettySocketProperties.getBossThreads() > 0 ? new NioEventLoopGroup(nettySocketProperties.getBossThreads()) : new NioEventLoopGroup();
    }

    @Bean(name = "worker")
    public NioEventLoopGroup getWorker() {
        return nettySocketProperties.getWorkerThreads() > 0 ? new NioEventLoopGroup(nettySocketProperties.getWorkerThreads()) : new NioEventLoopGroup();
    }
}
