package org.wechat.custom.entity.results;

/**
 * 在线客服接待信息
 * 
 * @author Andy
 * 
 */
public class LinekFlist {
	private String kf_account; // 完整客服账号，格式为：账号前缀@公众号微信号
	private int status; // 客服在线状态 1：pc在线，2：手机在线。若pc和手机同时在线则为 1+2=3
	private int kf_id; // 客服工号
	private int auto_accept; // 客服设置的最大自动接入数
	private int accepted_case; // 客服当前正在接待的会话数

	public String getKf_account() {
		return kf_account;
	}

	public void setKf_account(String kfAccount) {
		kf_account = kfAccount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getKf_id() {
		return kf_id;
	}

	public void setKf_id(int kfId) {
		kf_id = kfId;
	}

	public int getAuto_accept() {
		return auto_accept;
	}

	public void setAuto_accept(int autoAccept) {
		auto_accept = autoAccept;
	}

	public int getAccepted_case() {
		return accepted_case;
	}

	public void setAccepted_case(int acceptedCase) {
		accepted_case = acceptedCase;
	}
}
