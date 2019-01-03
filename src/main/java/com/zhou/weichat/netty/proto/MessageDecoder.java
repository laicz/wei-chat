/**
 * Date:     2018/12/3111:23
 * AUTHOR:   Administrator
 */
package com.zhou.weichat.netty.proto;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * 2018/12/31  11:23
 * created by zhoumb
 */
public class MessageDecoder extends ReplayingDecoder<ReplaySingal> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    }
}
