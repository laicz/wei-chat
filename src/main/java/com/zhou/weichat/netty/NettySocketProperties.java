/**
 * Date:     2018/12/2822:51
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.netty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



/**
 * 2018/12/28  22:51
 * created by zhoumb
 */
@Component
@PropertySource("classpath:netty-socket-server.properties")
@ConfigurationProperties
public class NettySocketProperties {

    @Value("${netty.socket.port}")
    private int port;
    @Value("${netty.socket.bossThreads}")
    private int bossThreads;
    @Value("${netty.socket.workerThreads}")
    private int workerThreads;

    public int getPort() {
        return port;
    }

    public int getBossThreads() {
        return bossThreads;
    }

    public int getWorkerThreads() {
        return workerThreads;
    }
}
