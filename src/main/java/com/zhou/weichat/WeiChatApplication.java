package com.zhou.weichat;

import com.spring4all.mongodb.EnableMongoPlus;
import com.zhou.weichat.netty.NettySocketProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
//@EnableAutoConfiguration    //自动加载配置文件
@EnableConfigurationProperties(NettySocketProperties.class)
@ComponentScan("com.zhou")  //配置扫描地址
@PropertySources({@PropertySource("classpath:spring-redis.properties"),
        @PropertySource("classpath:spring-mongodb.properties")})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableMongoPlus    //使用mongodb 连接池
public class WeiChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiChatApplication.class, args);
    }

}

