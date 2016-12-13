package org.wechat.ticket.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.wechat.common.entity.results.JsonResult;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.ticket.conn.TicketConn;

/**
 * 测试TicketConn
 * @author Andy
 *
 */
public class TestTicketConn {
	private TicketConn ticketConn;
	private String accessToken = "";
	
	@Before
	public void init(){
		ticketConn = new TicketConn();
		accessToken = "您的accessToken";
	}
	
	/**
	 * 创建临时二维码
	 * {"ticket":"gQFp8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL1Jrd1FGa0RsM0VhbEFkU0lsV0tpAAIE7doWVQMECAcAAA==",
	 * 
	 * "expire_seconds":1800,"url":"http:\/\/weixin.qq.com\/q\/RkwQFkDl3EalAdSIlWKi"}
	 */
	@Test
	public void testCreateTempTicke(){
		String result = ticketConn.createTempTicket(accessToken,1800, 1);
		assertNotNull(result);
		System.out.println(result);
	}
	
	/**
	 * 创建永久二维码
	 * {"ticket":"gQF_8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL1QwenRrbzNsUVVZNFE5OXNhR0NpAAIEBWenVAMEAAAAAA==","url":"http:\/\/weixin.qq.com\/q\/T0ztko3lQUY4Q99saGCi"}
	 */
	@Test
	public void testCreateForeverTicket(){
		String result = ticketConn.createForeverTicket(accessToken,1);
		assertNotNull(result);
		System.out.println(result);
	}
	
	/**
	 * 测试 获取二维码ticket后，开发者可用ticket换取二维码图片
	 * 下载二维码图片
	 */
	@Test
	public void testShowQrcode(){
		String ticket = "gQFp8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL1Jrd1FGa0RsM0VhbEFkU0lsV0tpAAIE7doWVQMECAcAAA==";
		String savePath = "F:\\test\\tick.jpg";
		try {
			WechatResult result = ticketConn.showQrcode(ticket,savePath);
			if(result.isSuccess()){
				System.out.println("保存成功!");
			}else if(result.isSuccess()==false){
				System.out.println(result.getObj().toString());
			}
			assertNotNull(result);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将长连接转换为短链接
	 */
	@Test
	public void testShorUrl(){
		JsonResult result = ticketConn.shorUrl(accessToken, "http://mp.weixin.qq.com/wiki/10/165c9b15eddcfbd8699ac12b0bd89ae6.html");
		assertNotNull(result);
		System.out.println(result.getErrcode());
		System.out.println(result.getErrmsg());
		System.out.println(result.getShort_url());
	}
	
}
