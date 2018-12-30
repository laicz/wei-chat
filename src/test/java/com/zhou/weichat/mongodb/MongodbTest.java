/**
 * Date:     2018/12/310:10
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.zhou.weichat.WeiChatApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 2018/12/31  0:10
 * created by zhoumb
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WeiChatApplication.class)
public class MongodbTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoClient client;

    @Test
    public void testInsert() {

        TestMongo mongo = new TestMongo();
        mongo.setName("test_mongo");
        mongoTemplate.insert(mongo);
    }

    @Test
    public void testMongoTemplate(){
        MongoClientOptions mongoClientOptions = client.getMongoClientOptions();
        int threadsAllowedToBlockForConnectionMultiplier = mongoClientOptions.getThreadsAllowedToBlockForConnectionMultiplier();
        System.out.println("threadAllow: " + threadsAllowedToBlockForConnectionMultiplier);
        System.out.println(mongoClientOptions.getHeartbeatFrequency());
    }

    @Document
    class TestMongo {
        @Indexed(background = true, sparse = true)
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
