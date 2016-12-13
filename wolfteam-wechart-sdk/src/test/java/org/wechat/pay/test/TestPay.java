package org.wechat.pay.test;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.common.utils.EncryptUtils;
import org.wechat.common.utils.Signature;
import org.wechat.pay.conn.PayConnection;
import org.wechat.pay.handler.PayHandler;
import org.wechat.pay.request.UnifiedOrderRequest;
import org.wechat.pay.response.UnifiedOrderResponse;
import org.wechat.pay.utils.RandomStringGenerator;

/**
 * 测试支付类
 * @author Andy
 *
 */
public class TestPay {
	
	@Test()
	public void testPayXml(){
		UnifiedOrderRequest request = new UnifiedOrderRequest();
		request.setAppid("appid");
		String xml = PayHandler.unifiedorder(request);
		System.out.println(xml);
	}
	
	/**
	 * 测试对象是否为空
	 */
	@Test
	public void testPayNotNull() throws IllegalAccessException{
		UnifiedOrderRequest orderQuerder = new UnifiedOrderRequest();
		orderQuerder.setAppid("appid");
		orderQuerder.setMch_id("mch_id");
		String sign = Signature.getSign(orderQuerder,"");
		System.out.println(sign);
	}
	
	/**
	 * 测试签名
	 */
	@Test
	public void testSign(){
		Map<String,String> params = new TreeMap<String,String>();
		params.put("return_code","SUCCESS");
		params.put("return_msg","OK");
		params.put("appid","您的公众号appid");
		params.put("mch_id","10012936");
		params.put("device_info","WEB");
		params.put("nonce_str","oApzl9vDmbAkAHGv");
		params.put("result_code","SUCCESS");
		params.put("trade_type","JSAPI");
		params.put("prepay_id","prepay_id");
		String sign = Signature.getSign(params,"");
		System.out.println(sign);
		//微信返回的sign是:   6E0D58A2FFB4C1E73FBA82D23A00941F
	}
	
	/**
	 * 订单号生成
	 */
	@Test
	public void testOrderCreate(){
		String id = RandomStringGenerator.getRandomStringByLength(32);
		System.out.println(id);
	}
	
	/**
	 * 测试支付
	 */
	@Test
	public void testPay(){
		UnifiedOrderRequest request = new UnifiedOrderRequest();
		request.setAppid("您的公众号appid");
		request.setMch_id("10012936");
		request.setDevice_info("WEB");					//可选
		request.setNonce_str("4735293714");
		request.setBody("这是测试商品描述");		
		request.setDetail("111");						//可选
		request.setAttach("这是测试api");						//可选
		request.setOut_trade_no("201505270218227522");
		request.setFee_type("CNY");				//
		request.setTotal_fee("10");
		request.setSpbill_create_ip("8.8.8.8");
		request.setTime_start("20150527021531");				//可选
		request.setTime_expire("20150527021531");				//可选
		request.setGoods_tag("WX");				//可选
		request.setNotify_url("http://www.baidu.com");
		request.setTrade_type("JSAPI");
		request.setProduct_id("1111");			//可选	
		request.setOpenid("o8ed_jv3vIC6l7Y8WQybls0xl8n0");					//可选  公众号支付为必须
		String sign = Signature.getSign(request,"7cfefba351c3db469ffdff3bf9d80be9");
		request.setSign(sign);
	    WechatResult result = PayConnection.payOrder(request);
		UnifiedOrderResponse response = (UnifiedOrderResponse) result.getObj();
			try {
				if(response.getReturn_code().equalsIgnoreCase("success")){
					boolean issuccess = Signature.checkIsSignValidFromResponseString(result.getMsg(),"7cfefba351c3db469ffdff3bf9d80be9"); //验证签名是否一致
					System.out.println(issuccess);
				}else{
					System.out.println("返回码失败-->"+result.getMsg());
				}
			} catch (Exception e) {
			}
	 }
	
	/**
	 * 测试网页签名
	 * noncestr=Wm3WZYTPz0wzccnW
	   jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg
	   timestamp=1414587457
       url=http://mp.weixin.qq.com?params=value
	 */
	@Test
	public void testPageSign(){
		TreeMap<String,Object> params = new TreeMap<String,Object>();
		params.put("noncestr","Wm3WZYTPz0wzccnW");
		params.put("jsapi_ticket","sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg");
		params.put("timestamp","1414587457");
		params.put("url","http://mp.weixin.qq.com?params=value");
		String sign = Signature.getSHA1Sign(params);
		System.out.println(sign);
	}
	
	/**
	 * 测试签名
	 * 1aeddc613c4933ed4cf128d585fcc7fa
	 */
	@Test
	public void testTwoSign(){
		String testString="appid=wx7c50b0eb849348d3&attach=这是测试api&body=这是测试商品描述&detail=111&device_info=WEB&fee_type=CNY&goods_tag=WX&mch_id=10012936&nonce_str=4735293714&notify_url=http://www.baidu.com&openid=o8ed_jv3vIC6l7Y8WQybls0xl8n0&out_trade_no=201505270218227522&product_id=1111&spbill_create_ip=8.8.8.8&time_expire=20150527021531&time_start=20150527021531&total_fee=10&trade_type=JSAPI&key=7cfefba351c3db469ffdff3bf9d80be9";
		System.out.println(testString.length());
		String data = EncryptUtils.EncryptMD5(testString).toUpperCase();
		System.out.println(data);
	}
}
