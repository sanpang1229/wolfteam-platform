package org.wechat.material.result;

/**
 * 上传多媒体返回的数据
 * 
 * @author Andy
 * 
 */
public class MaterMsg {
	private int errcode; // 错误码
	private String errmsg; // 错误的提示信息

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "MaterMsg [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
	
}
