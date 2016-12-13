package org.wechat.semantic.conn;

import java.util.TreeMap;

import org.wechat.common.conn.Connection;


/**
 * 语意理解接口(有待扩展)
 * @author Andy
 *
 */
public class SemanticConn extends Connection{
	
	//语意理解接口
	private String SeachPath="https://api.weixin.qq.com/semantic/semproxy/search";
	
	/**
	 * 语意理解接口
	 * @param accessToken	授权token
	 * @return				语意理解的接口	
	 */
	public String SeachRequest(String accessToken,String data){
		String result="";
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token", accessToken);
		result = HttpsDefaultExecute("POST",SeachPath,params,data);
		return result;
	}

}
