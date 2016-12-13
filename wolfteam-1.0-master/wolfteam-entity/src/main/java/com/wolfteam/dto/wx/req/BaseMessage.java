package com.wolfteam.dto.wx.req;
/**
 * 消息基类（普通用户 -> 公众帐号）
 * 
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年7月22日 下午4:49:45
 * 类说明
 *  请求消息的基类
 *	把消息推送中定义的所有消息都有的字段提取出来，封装成一个基类，
 *	这些公有的字段包括：ToUserName（开发者微信号）、FromUserName（发送方帐号，OPEN_ID）、CreateTime（消息的创建时间）、MsgType（消息类型）、MsgId（消息ID），封装后基类
 *
 * @version 0.1 
 *  
 */
public class BaseMessage {  
    // 开发者微信号  
    private String ToUserName;  
    // 发送方帐号（一个OpenID）  
    private String FromUserName;  
    // 消息创建时间 （整型）  
    private long CreateTime;  
    // 消息类型（text/image/location/link）  
    private String MsgType;  
    // 消息id，64位整型  
    private long MsgId;  
  
    public String getToUserName() {  
        return ToUserName;  
    }  
  
    public void setToUserName(String toUserName) {  
        ToUserName = toUserName;  
    }  
  
    public String getFromUserName() {  
        return FromUserName;  
    }  
  
    public void setFromUserName(String fromUserName) {  
        FromUserName = fromUserName;  
    }  
  
    public long getCreateTime() {  
        return CreateTime;  
    }  
  
    public void setCreateTime(long createTime) {  
        CreateTime = createTime;  
    }  
  
    public String getMsgType() {  
        return MsgType;  
    }  
  
    public void setMsgType(String msgType) {  
        MsgType = msgType;  
    }  
  
    public long getMsgId() {  
        return MsgId;  
    }  
  
    public void setMsgId(long msgId) {  
        MsgId = msgId;  
    }  
}  