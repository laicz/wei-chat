/**
 * Date:     2018/12/2822:34
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.config;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2018/12/28  22:34
 * created by zhoumb
 */
@Configuration
public class NettySocketConfig {

    @Bean(name = "boss")
    public NioEventLoopGroup getBoss() {
        return new NioEventLoopGroup();
    }

    @Bean(name = "worker")
    public NioEventLoopGroup getWorker() {
        return new NioEventLoopGroup();
    }
}
