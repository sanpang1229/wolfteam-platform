package org.wechat.common.test;

import java.util.TreeMap;

import org.junit.Test;
import org.wechat.common.conn.Connection;
import org.wechat.common.utils.EncryptUtils;

/**
 * 测试连接
 * @author Andy
 *
 */
public class TestConnection {
	
	/**
	 * 测试设置参数
	 */
	@Test
	public void testSetParams(){
		Connection conn = new Connection();
		TreeMap<String,String> map = new TreeMap<String,String>();
		map.put("name","张三");
		map.put("sex","姓名");
		map.put("class","s");
		String tespath ="https://api.weixin.qq.com/cgi-bin/token";
		//https://api.weixin.qq.com/cgi-bin/getcallbackip
		//http://file.api.weixin.qq.com/cgi-bin/media/upload
		try {
			String path =conn.SetParmas(map, tespath,"");
			System.out.println("path------>"+path.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试获取token
	 * 您公众号key
	 * 您公众号secret
	 * {"access_token":"授权token","expires_in":7200}
	 */
	@Test 
	public void testGetToken(){
		String key="您公众号key";
		String secret="您公众号secret";
		String path="https://api.weixin.qq.com/cgi-bin/token?";
		TreeMap<String,String> map = new TreeMap<String,String>();
		map.put("grant_type", "client_credential");
		map.put("appid",key);
		map.put("secret",secret);
		Connection conn = new Connection();
		String result = conn.HttpDefaultExecute("GET", path, map,"");
		System.out.println("result------>"+result);
	}
	
	/**
	 * 获取服务器ip
	 * 返回结果
	 * result--->{"ip_list":["101.226.62.77","101.226.62.78","101.226.62.79","101.226.62.80","101.226.62.81","101.226.62.82","101.226.62.83","101.226.62.84","101.226.62.85","101.226.62.86","101.226.103.59","101.226.103.60","101.226.103.61","101.226.103.62","101.226.103.63","101.226.103.69","101.226.103.70","101.226.103.71","101.226.103.72","101.226.103.73","140.207.54.73","140.207.54.74","140.207.54.75","140.207.54.76","140.207.54.77","140.207.54.78","140.207.54.79","140.207.54.80"]}
	 */
	@Test
	public void testGetCallBackIp(){
		Connection conn = new Connection();
		String result = conn.getCallBackIp("gOR7OdOv20Lyui3jOEutdMhrWQr3k7lvavSNs4Re6H55kjPTccUI2W4LG54_2uKTbBWkituqZcNcxXYHT0smd4tfQowXMrEU_tYRBHtxhDA");
		System.out.println("result--->"+result);
	}
	
	/**
	 * 测试加密
	 */
	@Test
	public void testEncript(){
		try{
			System.out.println(EncryptUtils.EncryptMD5("122121212"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 测试上传多媒体media信息
	 * 返回结果
	 * {"type":"image","media_id":"otW4BIszBN_Z9hmjKvvRfIjbBjoWIRyAk2LbiJJ3audoTLl6_sMgJzF6jlUW9tf0","created_at":1427555290}

	 * {"type":"image","media_id":"1fSa0bBL-KGMoCROTbkACMupqqAJd4TI2jeMZUBQpqURb8DymLYkV-9XxkGzKLU0","created_at":1427632845}


	 */
	@Test
	public void testDefaultUploadImg(){
		Connection conn = new Connection();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token","LIlR-WrXeGVIKidszgCHCejUmmggiSuF43RuUNPkh2NKVQYVVOSKOTLSqyrAr0U6I_M7z9iwetGUQOb95oXVMB-cRdX91bjkryBD5_flGPw");
		params.put("type","image");
		String result = conn.BasicUploadImg(params, "","http://img60.aili.com/1a/a5/1aa56c1153fefa3f9402b22f3b03ccf1.png","");
		System.out.println(result);
	}
	
}
