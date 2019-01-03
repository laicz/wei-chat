/**
 * Date:     2019/1/322:29
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.repository;

import com.zhou.weichat.model.ChatSession;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2019/1/3  22:29
 * created by zhoumb
 */
public interface ChatSessionRepository extends MongoRepository<ChatSession, String> {
}
