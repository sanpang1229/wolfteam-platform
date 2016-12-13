package org.wechat.pay.request;

import java.util.Map;
import java.util.TreeMap;

/**
 * 转换短链接
 * @author Andy
 *
 */
public class ShortUrlRequest extends BasicPayParams{
	private String long_url;  //url链接

	public String getLong_url() {
		return long_url;
	}

	public void setLong_url(String longUrl) {
		long_url = longUrl;
	}

	/*@Override
	public Map<String, String> getParams() {
		Map<String,String> params = new TreeMap<String,String>();
		params.put("long_url",this.long_url);
		params.putAll(getCommonParams());
		return params;
	}
	*/
	
}
