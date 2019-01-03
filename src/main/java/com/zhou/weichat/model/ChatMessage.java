/**
 * Date:     2019/1/322:12
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.model;

import com.zhou.weichat.model.en.ChatType;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * 会话信息
 * 2019/1/3  22:12
 * created by zhoumb
 */
public class ChatMessage {
    private static final int UN_READ = 0;
    private static final int READ = 1;

    private String id;
    @Indexed(background = true, sparse = true)
    private String userId;
    @Indexed(background = true, sparse = true)
    private String toUserId;
    @Indexed(background = true, sparse = true)
    private String sessionId;
    private ChatType chatType;
    private String content;
    private int readStatus;
    @Indexed(background = true, sparse = true)
    private String ctime;
    @Indexed(background = true, sparse = true)
    private String rtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public ChatType getChatType() {
        return chatType;
    }

    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }
}
