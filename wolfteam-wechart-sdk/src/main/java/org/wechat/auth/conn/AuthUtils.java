package org.wechat.auth.conn;

import java.util.Map;
import java.util.TreeMap;

import org.wechat.auth.request.AbstractRequest;
import org.wechat.auth.request.AuthTokenRequest;
import org.wechat.auth.request.AuthUserRequest;
import org.wechat.auth.request.RefreshTokenRequest;
import org.wechat.auth.response.AuthTokenResponse;
import org.wechat.auth.response.AuthUserInfo;
import org.wechat.common.conn.Connection;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.common.entity.results.ResultState;
import org.wechat.common.utils.ConvertJsonUtils;

/**
 * 授权工具类
 * @author Andy
 *
 */
public class AuthUtils extends Connection{
	private static final String AUTHPATH="https://open.weixin.qq.com/connect/oauth2/authorize";			//授权链接
	private static final String TOKENPATH="https://api.weixin.qq.com/sns/oauth2/access_token";			//获取token的链接
	private static final String REFRESHTOKEN="https://api.weixin.qq.com/sns/oauth2/refresh_token";		//刷新token
	//获取授权用户信息
	private static final String USERINFO="https://api.weixin.qq.com/sns/userinfo";
	//判断用户accessToken是否有效
	private static final String AUTH="https://api.weixin.qq.com/sns/auth";
	
	
	/**
	 * 获取授权请求path
	 * @return
	 * @throws Exception 
	 */
	public String getRequestPath(AbstractRequest request) throws Exception{
		Map<String,String> params = request.getParams();
		String path = SetParmas(params, AUTHPATH,"")+"#wechat_redirect";
		return path;
	}
	
	
	/**
	 *  检验授权凭证（access_token）是否有效
	 * @param accessToken 网页授权接口调用凭证
	 * @param openid		用户的唯一标识
	 * @return  { "errcode":0,"errmsg":"ok"}表示成功     { "errcode":40003,"errmsg":"invalid openid"}失败
	 */
	public ResultState authToken(String accessToken,String openid){
		Map<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		params.put("openid", openid);
		String jsonResult = HttpDefaultExecute("GET",AUTH, params,"");
		ResultState state = ConvertJsonUtils.jsonToJavaObject(jsonResult,ResultState.class);
		return state;
	}
	
	/**
	 * 通过code获取accessToken
	 * @param request	AuthTokenRequest 必须给其赋值
	 * @return   result.success==true 返回的是 AuthTokenRequest 否则返回错误提示信息
	 */
	public WechatResult getAccessTokenByCode(AuthTokenRequest request){
		WechatResult result = new WechatResult();
		Map<String,String> params =request.getParams();
		try {
			String path = SetParmas(params, TOKENPATH,"");
			String jsonResult = HttpDefaultExecute("GET", path, params,"");
			result  = ConvertJsonUtils.ConvertJavaObjectByKeyword(jsonResult,AuthTokenResponse.class,"access_token");
		} catch (Exception e) {
			result.setObj(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 刷新token
	 * @param request
	 * @return	result.success==true 返回的是 AuthTokenRequest 否则返回错误提示信息
	 */
	public WechatResult getRefreshToken(RefreshTokenRequest request){
		 WechatResult result = new WechatResult();
		 try {
			Map<String, String> params = request.getParams();
			String path = SetParmas(params, REFRESHTOKEN, "");
			String jsonResult = HttpDefaultExecute("GET", path, params, "");
			result = ConvertJsonUtils.ConvertJavaObjectByKeyword(jsonResult,AuthTokenResponse.class, "access_token");
		} catch (Exception e) {
			result.setObj(e.getMessage());
		}
		 return result;
	}
	
	/**
	 * 获取网页授权页面请求
	 * @param request	请求参数对象
	 * @return  result.success==true 表示返回 AuthUserInfo  否则返回对应错误提示信息
	 */
	public WechatResult getAuthUserInfo(AuthUserRequest request){
		WechatResult result = new WechatResult();
		try {
			Map<String, String> params = request.getParams();
			String path = SetParmas(params, USERINFO, "");
			String jsonResult = HttpDefaultExecute("GET", path, params, "");
			result = ConvertJsonUtils.ConvertJavaObjectByKeyword(jsonResult,AuthUserInfo.class, "openid");
		} catch (Exception e) {
			result.setObj(e.getMessage());
		}
		return result;
	}
}
