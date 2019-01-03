/**
 * Date:     2019/1/322:26
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.service.impl;

import com.zhou.weichat.model.ChatSession;
import com.zhou.weichat.model.en.ChatStatus;
import com.zhou.weichat.netty.ChannelSession;
import com.zhou.weichat.service.ChatSessionService;
import org.springframework.stereotype.Service;

/**
 * 2019/1/3  22:26
 * created by zhoumb
 */
@Service
public class ChatSessionServiceImpl implements ChatSessionService {
    @Override
    public ChatSession findOrCreateSession(ChannelSession channelSession, ChatStatus chatStatus) {

    }
}
