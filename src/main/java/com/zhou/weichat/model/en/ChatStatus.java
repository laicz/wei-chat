/**
 * Date:     2019/1/322:07
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.model.en;

/**
 * 用户状态
 * 2019/1/3  22:07
 * created by zhoumb
 */
public enum ChatStatus {
    LOGIN(1,"登录"),
    OFFLINE(2,"离线")
    ;
    private int value;
    private String msg;

    ChatStatus(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
