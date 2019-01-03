/**
 * Date:     2019/1/223:05
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.netty.utils;

import com.google.common.collect.Maps;
import com.zhou.weichat.netty.ChannelSession;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Channel 管理类
 * 2019/1/2  23:05
 * created by zhoumb
 */
public class ChannelManager {
    private static Map<String, ChannelSession> clientChannelSessions = Maps.newConcurrentMap();

    private ChannelManager() {
    }

    /**
     * 用户登录  添加ChannelSession
     *
     * @param userId
     * @param channelSession
     * @return
     */
    public static Map<String, ChannelSession> addChannelSession(String userId, ChannelSession channelSession) {
        clientChannelSessions.put(userId, channelSession);
        return clientChannelSessions;
    }

    /**
     * 用户登出 移除ChannelSession
     *
     * @param userId
     * @return
     */
    public static Map<String, ChannelSession> removeChannelSession(String userId) {
        clientChannelSessions.remove(userId);
        return clientChannelSessions;
    }

    /**
     * 获取用户的ChannelSession
     *
     * @param userId
     * @return
     */
    public static ChannelSession getChannelSession(String userId) {
        return clientChannelSessions.get(userId);
    }

    /**
     * 当前用户是否存在ChannelSession
     *
     * @param userId
     * @return
     */
    public static boolean contain(String userId) {
        return clientChannelSessions.keySet().contains(userId);
    }

    /**
     * 获取所有的登录用户ChannelSession
     *
     * @return
     */
    public static Set<String> loginUserIds() {
        return clientChannelSessions.keySet();
    }

    /**
     * 获取登录 clientSessions
     *
     * @return
     */
    public static Map<String, ChannelSession> getChannelSessions() {
        return clientChannelSessions;
    }

    /**
     * 获取登录用户 size
     *
     * @return
     */
    public static long getChannelSessionSize() {
        return clientChannelSessions.size();
    }


}
