package org.wechat.user.test;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wechat.common.entity.results.AccessToken;
import org.wechat.common.entity.results.JsonResult;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.user.conn.UserConnection;
import org.wechat.user.entity.WeixinUser;

import com.alibaba.fastjson.JSONObject;

/**
 * 测试用户连接
 * @author Andy
 *
 */
public class TestUserConnection {
	private UserConnection userConn;
	private String accessToken = "";
	
	@Before
	public void init(){
		userConn = new UserConnection();
		accessToken = "3qwJbEIIywJzYHZc7ry-xNIm2jVx4v_gVMFrcYtqfgilBlSZ5RHYL2LKOXJa3rXRJPbfFut261vOhPA2QLuunSASuasqlOueY7CJA0HvObd8_ffA8-ys0XhpYu6GmJe_RUPfAEACFA";
	}
	/**
	 * 第一种方式
	 * {"group":{"name":"test"}}
	 */
	@Test
	public void testJsonData(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","test");
		Map<String,Map<String,String>> testMap = new HashMap<String,Map<String,String>>();
		testMap.put("group",map);
		System.out.println(JSONObject.toJSONString(testMap));
	}
	
	@Test
	public void testClassName(){
		String jsonStr ="{errcode:0,errmsg:ok}";
		
	}
	
	/**
	 * 排序
	 */
	@Test
	public void testSort(){
		String[] array = {"aewewewe","sdsdsdsd","cdewewew"};
		Arrays.sort(array);
		for(String str:array){
			System.out.println(str);
		}
	}
	
	/**
	 * 测试创建分组
	 * {"group":{"id":101,"name":"testName"}}
	 */
	@Test
	public void testCreateGroup(){
		String result = userConn.createGroup(accessToken, "testName");
		Assert.assertNotNull(result);
		System.out.println(result);
	}
	
	/**
	 * 获取分组信息
	 * {"groups":[{"id":0,"name":"默认组","count":157},{"id":1,"name":"屏蔽组","count":0},{"id":2,"name":"星标组","count":0},{"id":100,"name":"testName","count":0}]}
	 */
	@Test
	public void testQueryGroups(){
		String result=userConn.queryGroups(accessToken);
		Assert.assertNotNull(result);
		System.out.println(result);
	}
	
	/**
	 * 测试指定查询用户所在的用户
	 * 返回结果 	 {"groupid":0}
	 */
	@Test
	public void testGetGroupId(){
		String openid = "obc-3jttvh09pNP8BmodxhkxaCzo";
		String result=userConn.getGroupId(accessToken,openid);
		Assert.assertNotNull(result);
		System.out.println(result);
	}
	
	/**
	 * 修改分组名
	 * JsonResult
	 * errorCode-->0  getErrmsg-->ok 表示成功
	 */
	@Test
	public void testUpdateGroupName(){
		    JsonResult result = userConn.updateGroupName(accessToken,101, "新的分组名称");
			Assert.assertNotNull(result);
			System.out.println("errorCode-->"+result.getErrcode());
			System.out.println("getErrmsg-->"+result.getErrmsg());
		}
	
	/**
	 * 移动用户分组
	 * JsonResult
	 * errorCode-->0  getErrmsg-->ok 表示成功
	 */
	@Test
	public void testMoveUserGroup(){
		String openid = "oZq7Bt2gISuKEQQeSoEogSNj2AzQ";
		JsonResult result = userConn.moveUserGroup(accessToken, openid,100);
		Assert.assertNotNull(result);
		System.out.println("errorCode-->"+result.getErrcode());
		System.out.println("getErrmsg-->"+result.getErrmsg());
	}
	
	/**
	 * 设置用户的备注名称
	 * JsonResult
	 * errorCode-->0  getErrmsg-->ok 表示成功
	 */
	@Test
	public void testRemarkUserName(){
		String openid = "您的openid";
		JsonResult result = userConn.remarkUserName(accessToken,openid,"测试备注名称");
		Assert.assertNotNull(result);
		System.out.println("errorCode-->"+result.getErrcode());
		System.out.println("getErrmsg-->"+result.getErrmsg());
	}
	
	/**
	 * 获取用户基本信息
	 * {"subscribe":1,"openid":"您的openid","nickname":"誓言","sex":1,
	 */
	@Test
	public void testUnionIDUserInfo(){
		String openid = "您的openid";
		String accessToken="您的accessToken";
		WechatResult obj = userConn.unionIDUserInfo(accessToken,openid,"zh_CN");
		WeixinUser user  = (WeixinUser) obj.getObj();
		assertNotNull(user);
		System.out.println(user.getOpenid());
	}
	
	/**
	 * 测试获取用户列表
	 * "total":157,"count":157,"data":{"openid":["obc-3jnpwZvfJRqRT0gfgeMe7EVc","obc-3jq8Gw_ax3Tbt43tisYRKbBs","obc-3jhk5mEhKrJp2JOsaG0cgYLg","obc-3jtssch1YUHqgvz04sFEJ8lM","
	 */
	@Test
	public void testGetUserList(){
		String result = userConn.getUserList(accessToken, "");
		assertNotNull(result);
		System.out.println(result);
	}
	
	/**
	 * 刷新access_token
	 */
	@Test
	public void testGetTokenByRefreshToken(){
		String appid = "";
		String refreshToken = "";
		WechatResult token = userConn.getTokenByRefreshToken(appid, refreshToken);
		if(token.isSuccess()){
			System.out.println(token.isSuccess());
		}
	}
	
	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 */
	@Test
	public void testGetBySnsapiUserInfo(){
		String openid = "您的openid";
		String token="您的token";
		WechatResult user = userConn.getBySnsapiUserInfo(token,openid,"zh_CN");
		assertNotNull(user);
		WeixinUser wUser = (WeixinUser) user.getObj();
		System.out.println(user.getMsg());
	}

	/**
	 * 测试检验授权凭证（access_token）是否有效
	 * errorCode-->40001
	 * getErrmsg-->invalid credential		无效
	 */
	@Test
	public void testTestTokenValid(){
		String openid = "您的openid";
		JsonResult result = userConn.testTokenValid("OezXcEiiBSKSxW0eoylIeEDjCaTvqOjan-GmTNbArTy8b2UBfJFrjcunAk2wQbUjO5tnn-eXSlOEy9ajI_voKP4ODomR22di26oSAEepRnf-eYrwOa-LaF5yijZJScGgQAjHXKXB0jODXcSCq-pFkw",openid);
		Assert.assertNotNull(result);
		System.out.println("errorCode-->"+result.getErrcode());
		System.out.println("getErrmsg-->"+result.getErrmsg());
	}
	
	@Test
	public void testTokenPath(){
		try {
			String path = UserConnection.getAuthCodeUrl("您的公众号appid","回调地址","snsapi_userinfo","state");
			System.out.println(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
