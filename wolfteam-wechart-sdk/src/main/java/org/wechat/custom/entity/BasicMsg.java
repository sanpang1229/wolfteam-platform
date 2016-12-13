package org.wechat.custom.entity;

/**
 * 客服消息中的基类
 * @author Andy
 *
 */
public abstract class BasicMsg {
	private String touser;		//普通用户openid
	private String msgtype=setMsgtype();		//消息类型，text
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	public String getMsgtype() {
		return msgtype;
	}
	public abstract String setMsgtype();

}
