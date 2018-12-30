/**
 * Date:     2018/12/2822:23
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.netty;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

}
