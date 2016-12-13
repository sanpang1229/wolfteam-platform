package org.wechat.custom.entity;

/**
 * 会话实体
 * 
 * @author Andy
 * 
 */
public class SessionEntity {
	private String openid; // 客户openid
	private String kf_account; // 完整客服账号，格式为：账号前缀@公众号微信号
	private String text; // 附加消息

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getKf_account() {
		return kf_account;
	}

	public void setKf_account(String kfAccount) {
		kf_account = kfAccount;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
