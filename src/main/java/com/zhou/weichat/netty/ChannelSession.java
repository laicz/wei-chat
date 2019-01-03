/**
 * Date:     2019/1/120:18
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.netty;

import io.netty.channel.Channel;

/**
 * Channel session
 * 2019/1/1  20:18
 * created by zhoumb
 */
public class ChannelSession {
    private String userId;  //用户Id
    private Channel channel;//用户当前连接channel
    private int type;       //1:IM 2:API 3:WS
    private long psnTime = 0;//发送给用户PSN时间戳
    private long synFinTime = 0;//用户同步消息结束时间

    public ChannelSession(Channel channel) {
        this.channel = channel;
    }

    public ChannelSession(String userId, Channel channel) {
        this.userId = userId;
        this.channel = channel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getPsnTime() {
        return psnTime;
    }

    public void setPsnTime(long psnTime) {
        this.psnTime = psnTime;
    }

    public long getSynFinTime() {
        return synFinTime;
    }

    public void setSynFinTime(long synFinTime) {
        this.synFinTime = synFinTime;
    }
}
