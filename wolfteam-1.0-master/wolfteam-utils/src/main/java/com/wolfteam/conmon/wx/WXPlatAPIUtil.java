package com.wolfteam.conmon.wx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wolfteam.util.http.HttpUtil;

import net.sf.json.JSONObject;
public class WXPlatAPIUtil {
	private static final String WOLFTEAM_WEIXIN_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=WOLFTEAM_APPID&secret=WOLFTEAM_APPSECRET";
	private static final String WOLFTEAM_WEIXIN_CALLBACK_SERVERIPLIST = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
	private static final String WOLFTEAM_WEIXIN_PERSON_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=WOLFTEAM_ACCESS_TOKEN&openid=WOLFTEAM_OPENID&lang=zh_CN ";
	private static final String WOLFTEAM_WEIXIN_MESSAGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/message";
	private static final String WOLFTEAM_WEIXIN_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu";
	private static final String WOLFTEAM_WEIXIN_AUTH_INFO = "https://qyapi.weixin.qq.com/cgi-bin/service/get_auth_info";
	private static Log log = LogFactory.getLog(WXPlatAPIUtil.class);
	
	/**
	 * 获取AccessToken接口
	 */
	public static JSONObject getAccessToken(String appid, String  appsecret) {
		try {
			String url = WOLFTEAM_WEIXIN_ACCESSTOKEN_URL.replace("WOLFTEAM_APPID", appid).replace("WOLFTEAM_APPSECRET", appsecret);
			return HttpUtil.httpsRequest(url, "GET", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		/*JSONObject o = WXPlatAPIUtil.getAccessToken("wx94173ae840e4c429", "fce2c755a2cfaa2e7c660929436545d0");
		System.out.println(o);*/
		JSONObject p =null;
		try {
			 p =getSubscribeUser("ozF6Vc7dFoteTColWwU0jGf3Tpk6EmW9kQ3Bui9V32rX6S2q7ZRkZhAcZDUvwODsqdhhtyE9kTu0sDoAluqcSYWTvhMl1aK6Ph0s5P0DDCcAe-m9BSZNn-qWkseNZcy6RPUbAEAFDI", "oGIarwhmcwJ7doKFXUg95sZ_96mY");
			 System.out.println(p);
		} catch (Exception e) {
			System.out.println(p);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建菜单
	 */
	public static JSONObject createAPPMenu(String accesstoken, String xml) {
		try {
			log.error("创建菜单token:"+accesstoken+",xml:"+xml);
			String url = WOLFTEAM_WEIXIN_MENU_URL + "/create?access_token=" + accesstoken;
			return HttpUtil.httpsRequest(url, "POST", xml);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 删除菜单
	 */
	public static JSONObject delAPPMenu(String accesstoken) throws Exception {
		String url = WOLFTEAM_WEIXIN_MENU_URL + "/delete?access_token=" + accesstoken ;
		return HttpUtil.httpsRequest(url, "GET", null);
	}

	/**
	 * 获取菜单
	 */
	public static JSONObject getAPPMenu(String accesstoken) throws Exception {
		String url = WOLFTEAM_WEIXIN_MENU_URL + "/get?access_token=" + accesstoken ;
		return HttpUtil.httpsRequest(url, "GET", null);
	}
	
	/**
	 * 获取用户信息
	 */
	public static JSONObject getSubscribeUser(String accesstoken,String fromUser) throws Exception {
		String url = WOLFTEAM_WEIXIN_PERSON_URL.replace("WOLFTEAM_ACCESS_TOKEN", accesstoken).replace("WOLFTEAM_OPENID", fromUser);
		return HttpUtil.httpsRequest(url, "GET", null);
	}

}
