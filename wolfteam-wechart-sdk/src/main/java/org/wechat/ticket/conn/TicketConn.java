package org.wechat.ticket.conn;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.wechat.common.conn.Connection;
import org.wechat.common.entity.results.JsonResult;
import org.wechat.common.entity.results.WechatResult;

import com.alibaba.fastjson.JSONObject;

/**
 * 推广支持连接类(测试已经通过)
 * @author Andy
 *
 */
public class TicketConn extends Connection{
	//临时二维码
	private final static String QR_SCENE="QR_SCENE";
	//永久二维码
	private final static String QR_LIMIT_SCENE="QR_LIMIT_SCENE";
	//长链接转换为短连接
	private final static String LONGTOWSHO="long2short";
	//创建二维码
	private String create_ticket_path="https://api.weixin.qq.com/cgi-bin/qrcode/create";
	//通过ticket换取二维码
	private String showqrcode_path="https://mp.weixin.qq.com/cgi-bin/showqrcode";
	//长链接转换为短链接
	private String shorUrl="https://api.weixin.qq.com/cgi-bin/shorturl";
	
	/**
	 * 创建临时二维码
	 * @param accessToken		授权token
	 * @param expire_seconds	该二维码有效时间，以秒为单位。 最大不超过1800。
	 * @param scene_id			场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @return
	 */
	public String createTempTicket(String accessToken,int expire_seconds,int scene_id){
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token", accessToken);
		Map<String,Integer> intMap = new HashMap<String,Integer>();
		intMap.put("scene_id",scene_id);
		Map<String,Map<String,Integer>> mapMap = new HashMap<String,Map<String,Integer>>();
		mapMap.put("scene", intMap);
		//
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("expire_seconds", expire_seconds);
		paramsMap.put("action_name", QR_SCENE);
		paramsMap.put("action_info", mapMap);
		String data = JSONObject.toJSONString(paramsMap);
		data = HttpsDefaultExecute("POST",create_ticket_path,params,data);
		return data;
	}
	
	/**
	 * 创建永久二维码
	 * @param accessToken		授权token
	 * @param scene_id		场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000)
	 * @return
	 */
	public String createForeverTicket(String accessToken,int scene_id){
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token", accessToken);
		//output data
		Map<String,Integer> intMap = new HashMap<String,Integer>();
		intMap.put("scene_id",scene_id);
		Map<String,Map<String,Integer>> mapMap = new HashMap<String,Map<String,Integer>>();
		mapMap.put("scene", intMap);
		//
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("action_name", QR_LIMIT_SCENE);
		paramsMap.put("action_info", mapMap);
		String data = JSONObject.toJSONString(paramsMap);
		data =  HttpsDefaultExecute("POST",create_ticket_path,params,data);
		return data;
	}
	
	/**
	 * 获取二维码ticket后，开发者可用ticket换取二维码图片
	 * @param ticket   通过创建临时二维码/永久二维码 接口 获得
	 * @param savePath  保存的路径,例如 F:\\test\test.jpg
	 * @return		Result.success = true 表示下载图片下载成功
	 */
	public WechatResult showQrcode(String ticket,String savePath)throws Exception{
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("ticket",URLEncoder.encode(ticket,default_charset));
		WechatResult result = downMeaterMetod(params,"GET",showqrcode_path,savePath);
		return result;
	}
	
	/**
	 * 将一条长链接转成短链接。
	 * @param accessToken	授权token 调用接口凭证
	 * @param long_url		需要转换的长链接，支持http://、https:// weixin://wxpay 格式的url
	 * @return
	 */
	public JsonResult shorUrl(String accessToken,String long_url){
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token", accessToken);
		Map<String,String> map = new HashMap<String,String>();
		map.put("action", LONGTOWSHO);
		map.put("long_url", long_url);
		String data = JSONObject.toJSONString(map);
		String jsonResult = HttpsDefaultExecute("POST",shorUrl,params,data);
		return ConvertResult(jsonResult);
	}
	
}
