package org.wechat.msg.test;

import org.junit.Before;
import org.junit.Test;
import org.wechat.msg.result.MsgResult;
import org.wechat.msg.templet.LogisticsThemple;

/**
 * 测试物流模板消息
 * @author Andy
 *
 */
public class TestLogisticsThemple {
	private LogisticsThemple logistics;
	private String accessToken;
	
	@Before
	public void init(){
		logistics = new LogisticsThemple();
		accessToken = "wnMNXeeFrBNiR72bPhBGohG4o6uxgiD-8-40qSUG48USGIIZNSk9TWjXAd3Y0aX0sK_T5gUxp0H7K0-axjuopdi6U3kx4l83mwsKw_eKRZc";
	}
	

	/**
	 * 发送模板消息
	 * 
	 */
	@Test
	public void testSendTemplatedId(){
		String templeId = "ENSKygTrrWWpeWJ3WUowSQidOi5IxtvtSg0wBrTzUp8";
		String url = "http://www.baidu.com";
		String TopColor="#FF0000";
		String ContnetColor = "#173177";
		String title= "C0-xxxxxxx-xxxxxxx";
		String openid = "oZq7BtxHTUfedo4CNMrVHPVF2ZgU";
		MsgResult result = logistics.TOrderPackgerTrack(accessToken, openid, templeId, url, TopColor, ContnetColor, title, "1111", "packge", "PlageMenfinfo","careeInfo", "receiver", "remark");
		System.out.println(result.getErrcode());
		System.out.println(result.getErrmsg());
		System.out.println(result.getMsgid());
	}
	
	/**
	 * 发送物流状态信息
	 */
	@Test
	public void testTOrderStateChanage(){
		String openid = "oZq7BtxHTUfedo4CNMrVHPVF2ZgU";
		String templeId = "Ld2sLzTTpsln2nZ_Kg3Gr_RRqOaY84WbJ4085YwTz7E";
		String url = "www.baidu.com";
		String topColor="#FF0000";
		String contentColor = "#173177";
		String orderNumber = "1212121212";
		String status = "货物已到达广州市货物中转中心";
		String remark="回复M,查看更多信息";
		MsgResult result = logistics.TOrderStateChanage(accessToken, openid, templeId, url, topColor, contentColor, orderNumber, status, remark);
		System.out.println(result.getErrcode());
		System.out.println(result.getErrmsg());
		System.out.println(result.getMsgid());
	}
	
	/**
	 * 订单状态的改变
	 */
	@Test
	public void testTOrderStateConsigneeState(){
		String openid = "oZq7BtxHTUfedo4CNMrVHPVF2ZgU";
		String templeId = "Yz38tUINHWhUx4qoY41kKtBMC_ZxaohlAeU29SM13QQ";
		String url = "www.baidu.com";
		String topColor="#FF0000";
		String contentColor = "#173177";
		String orderNumber = "1212121212";
		String status = "收单状态";
		String remark="谢谢您的支持";
		String channel = "微信下单";
		String sometimes ="下午三点";
		MsgResult result = logistics.TOrderStateConsigneeState(accessToken, openid, templeId, url, topColor, contentColor, channel, orderNumber, status, sometimes, remark);
		System.out.println(result.getErrcode());
		System.out.println(result.getErrmsg());
		System.out.println(result.getMsgid());
	}
}
