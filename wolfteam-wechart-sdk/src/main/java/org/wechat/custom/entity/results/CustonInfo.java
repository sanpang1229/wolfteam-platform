package org.wechat.custom.entity.results;

/**
 * 获取客服信息 (获取客服基本信息)
 * 
 * @author Andy
 * 
 */
public class CustonInfo {
	private String kf_account;		//完整客服账号，格式为：账号前缀@公众号微信号，账号前缀最多10个字符，必须是英文或者数字字符。如果没有公众号微信号，请前往微信公众平台设置。
	private String kf_nick;			//客服昵称
	private int kf_id;				//客服工号
	private String kf_headimg;		//客服头像(注意在数据库中的字段最少200)

	public String getKf_account() {
		return kf_account;
	}

	public void setKf_account(String kfAccount) {
		kf_account = kfAccount;
	}

	public String getKf_nick() {
		return kf_nick;
	}

	public void setKf_nick(String kfNick) {
		kf_nick = kfNick;
	}

	public int getKf_id() {
		return kf_id;
	}

	public void setKf_id(int kfId) {
		kf_id = kfId;
	}

	public String getKf_headimg() {
		return kf_headimg;
	}

	public void setKf_headimg(String kfHeadimg) {
		kf_headimg = kfHeadimg;
	}
}
