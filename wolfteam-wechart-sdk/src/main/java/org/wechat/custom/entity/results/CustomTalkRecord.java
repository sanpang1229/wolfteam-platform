package org.wechat.custom.entity.results;

/**
 * 客服信息
 * 
 * @author Andy
 * 
 */
public class CustomTalkRecord {
	private String worker; // 客服账号
	private String openid; // 用户的标识，对当前公众号唯一
	private int opercode; // 操作ID（会话状态），具体说明见下文	1000 创建未接入会话
	private int time; // 操作时间，UNIX时间戳
	private String text; // 聊天记录

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getOpercode() {
		return opercode;
	}

	public void setOpercode(int opercode) {
		this.opercode = opercode;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
