/**
 * Date:     2019/1/321:49
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.model;

import com.zhou.weichat.model.en.ChatType;
import com.zhou.weichat.model.en.ChatStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 会话session
 * 2019/1/3  21:49
 * created by zhoumb
 */
@Document
public class ChatSession {
    @Id
    private String Id;
    @Indexed(background = true)
    private String userId;      //用户1 Id
    @Indexed(background = true)
    private String toUserId;    //用户2 Id
    private ChatType chatType; //会话类型 参考 ChatType
    private ChatStatus chatStatus;//用户登录状态
    @Indexed(background = true, sparse = true)
    private Date ctime; //会话创建时间
    @Indexed(background = true, sparse = true)
    private Date mtime; //会话最后一次发言时间

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public ChatType getChatType() {
        return chatType;
    }

    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
    }

    public ChatStatus getChatStatus() {
        return chatStatus;
    }

    public void setChatStatus(ChatStatus chatStatus) {
        this.chatStatus = chatStatus;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }
}
