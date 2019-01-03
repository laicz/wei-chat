/**
 * Date:     2018/12/3116:40
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.netty.constant;

import com.zhou.weichat.netty.ChannelSession;
import io.netty.util.AttributeKey;

/**
 * 2018/12/31  16:40
 * created by zhoumb
 */
public final class AttributeKeyConst {

    public static final AttributeKey<ChannelSession> SESSION = AttributeKey.valueOf("channelSession");
}
