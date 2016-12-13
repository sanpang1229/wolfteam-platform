package org.wechat.custom.entity.results;

/**
 * 在线会话
 * 
 * @author Andy
 * 
 */
public class OnLineSession {
	private String openid;
	private int createtime;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getCreatetime() {
		return createtime;
	}

	public void setCreatetime(int createtime) {
		this.createtime = createtime;
	}
}
