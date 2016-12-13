package org.wechat.pay.response;

import java.util.Map;

import org.wechat.pay.request.BasicPayParams;

/**
 * 转换短链接  返回结果
 * @author Andy
 *
 */
public class ShortUrlResponse extends BasicPayParams implements java.io.Serializable{
	private String result_code;
	private String err_code;
	private String short_url;
	
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
	public String getShort_url() {
		return short_url;
	}
	public void setShort_url(String shortUrl) {
		short_url = shortUrl;
	}
}	
