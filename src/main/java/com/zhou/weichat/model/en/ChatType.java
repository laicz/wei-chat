/**
 * Date:     2019/1/321:55
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.model.en;

/**
 * 会话类型
 * 2019/1/3  21:55
 * created by zhoumb
 */
public enum ChatType {
    PRIVATE_CHAT(0,"私聊"),
    GROUP_CHAT(1,"群聊"),
    NOTIFICATION(2,"系统通知")
    ;
    private int type;
    private String msg;

    ChatType(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
