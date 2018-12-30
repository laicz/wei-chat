/**
 * Date:     2018/12/3017:51
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.redis;

import com.alibaba.fastjson.JSON;
import com.zhou.weichat.WeiChatApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.util.JAXBSource;
import java.util.Date;

/**
 * 2018/12/30  17:51
 * created by zhoumb
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WeiChatApplication.class)
public class RedisConfigTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void ensureRedis() {
        System.out.println(redisTemplate);
    }

    @Test
    public void setString() {
        String key = "test_set_string";
        String value = String.valueOf(System.currentTimeMillis());
        redisTemplate.opsForValue().set(key, value);
//        redisTemplate.delete(key);
    }
}
