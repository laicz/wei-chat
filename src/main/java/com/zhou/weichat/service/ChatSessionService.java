/**
 * Date:     2019/1/322:25
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.service;

import com.zhou.weichat.model.ChatSession;
import com.zhou.weichat.model.en.ChatStatus;
import com.zhou.weichat.netty.ChannelSession;

/**
 * 2019/1/3  22:25
 * created by zhoumb
 */
public interface ChatSessionService {
    /**
     * 获取或者创建ChatSession
     * @param channelSession
     * @param chatStatus
     * @return
     */
    ChatSession findOrCreateSession(ChannelSession channelSession, ChatStatus chatStatus);
}
