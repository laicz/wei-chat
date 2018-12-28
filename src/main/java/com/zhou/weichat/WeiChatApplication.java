package com.zhou.weichat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration    //自动加载配置文件
@ComponentScan("com.zhou")
public class WeiChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiChatApplication.class, args);
    }

}

