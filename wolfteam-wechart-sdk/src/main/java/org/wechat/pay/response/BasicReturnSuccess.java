package org.wechat.pay.response;

import java.util.Map;

import org.wechat.pay.request.BasicPayParams;

/**
 * 基础的return_code为SUCCESS 是返回的结果集
 * @author Andy
 *
 */
public class BasicReturnSuccess extends BasicPayParams{
	private String result_code; // 业务结果码
	private String err_code; // 错误代码
	private String err_code_des; // 错误代码描述

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String resultCode) {
		result_code = resultCode;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String errCode) {
		err_code = errCode;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String errCodeDes) {
		err_code_des = errCodeDes;
	}

}
