package org.wechat.count.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.count.conn.CountConn;
import org.wechat.count.entity.InterAnlyseEntity;
import org.wechat.count.entity.MsgAnalyseEntity;
import org.wechat.count.entity.NewsAnlyseEntity;
import org.wechat.count.entity.UserAnlyseEntity;

/**
 * 测试CountConn中的方法
 * (已经测试完全)
 * @author Andy
 * 
 */
public class TestCountConn {
	private CountConn conn;
	private String accessToken;

	@Before
	public void init() {
		conn = new CountConn();
		accessToken = "OgbU7jK6On_D3lPaLXeq3_4mLHpPhRLT1__4Pitl1M0_R4gP5GFUtc__1UIRY473bP4piJBPwrqYO2rb-HR6mOI_19YAsPu5rhkbqpgis9w";
	}
	
	//用户分析接口
	@Test
	public void testGetUserSummary(){
		String startDate="2015-03-09";
		String endDate="2015-03-14";
		WechatResult result = conn.getUserSummary(accessToken, startDate, endDate);
		if(result.isSuccess()){
			List<UserAnlyseEntity> list = (List<UserAnlyseEntity>) result.getObj();
			if(list.size()>0){
				for(UserAnlyseEntity entity:list){
					System.out.println(entity.toString());
					System.out.println("--------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//获取累计用户接口
	@Test
	public void testGetusercumulate(){
		String startDate="2015-03-09";
		String endDate="2015-03-15";
		WechatResult result = conn.getUsercumulate(accessToken, startDate, endDate);
		if(result.isSuccess()){
			List<UserAnlyseEntity> list = (List<UserAnlyseEntity>) result.getObj();
			if(list.size()>0){
				for(UserAnlyseEntity entity:list){
					System.out.println(entity.toString());
					System.out.println("--------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//图文分析接口
	@Test
	public void testGetArticlesummary(){
		String startDate = "2015-03-03";
		String endDate="2015-03-03";
		WechatResult result = conn.getArticlesummary(accessToken,startDate, endDate);
		if(result.isSuccess()){
			List<NewsAnlyseEntity> entitys = (List<NewsAnlyseEntity>) result.getObj();
			if(entitys.size()>0){
				for(NewsAnlyseEntity entity:entitys){
					System.out.println(entity.toString());
					System.out.println("----------------------------------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//获取图文群发总数据
	@Test
	public void testGetArticletotal(){
		String startDate = "2015-03-03";
		String endDate="2015-03-03";
		WechatResult result = conn.getArticletotal(accessToken,startDate, endDate);
		if(result.isSuccess()){
			List<NewsAnlyseEntity> entitys = (List<NewsAnlyseEntity>) result.getObj();
			if(entitys.size()>0){
				for(NewsAnlyseEntity entity:entitys){
					System.out.println(entity.toString());
					System.out.println("----------------------------------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//获取图文统计数据接口(时间跨度为3天)
	@Test
	public void testGetArticleUserread(){
		String startDate = "2015-03-01";
		String endDate="2015-03-03";
		WechatResult result = conn.getArticleUserread(accessToken,startDate, endDate);
		if(result.isSuccess()){
			List<NewsAnlyseEntity> entitys = (List<NewsAnlyseEntity>) result.getObj();
			if(entitys.size()>0){
				for(NewsAnlyseEntity entity:entitys){
					System.out.println(entity.toString());
					System.out.println("----------------------------------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//图文统计小时数 (时间跨度为1天)
	@Test
	public void testgetArticleuserreadhour(){
		String startDate = "2015-03-01";
		String endDate="2015-03-01";
		WechatResult result = conn.getArticleuserreadhour(accessToken,startDate, endDate);
		if(result.isSuccess()){
			List<NewsAnlyseEntity> entitys = (List<NewsAnlyseEntity>) result.getObj();
			if(entitys.size()>0){
				for(NewsAnlyseEntity entity:entitys){
					System.out.println(entity.toString());
					System.out.println("----------------------------------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//图文分享数据
	@Test
	public void testGetusershare(){
		String startDate = "2015-03-01";
		String endDate="2015-03-07";
		WechatResult result = conn.getArticleusershare(accessToken,startDate, endDate);
		if(result.isSuccess()){
			List<NewsAnlyseEntity> entitys = (List<NewsAnlyseEntity>) result.getObj();
			if(entitys.size()>0){
				for(NewsAnlyseEntity entity:entitys){
					System.out.println(entity.toString());
					System.out.println("----------------------------------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}

	//图文分享转发时数据
	@Test
	public void testGetArticleusersharehour(){
		String startDate="2015-03-07";
		String endDate="2015-03-07";
		WechatResult result = conn.getArticleusersharehour(accessToken,startDate,endDate);
		if(result.isSuccess()){
			List<NewsAnlyseEntity> entitys = (List<NewsAnlyseEntity>) result.getObj();
			if(entitys.size()>0){
				for(NewsAnlyseEntity entity:entitys){
					System.out.println(entity.toString());
					System.out.println("------------------------------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//获取接口分析数据
	@Test
	public void testGetinterfacesummary(){
		String startDate="2015-02-10";
		String endDate="2015-02-28";
		WechatResult result = conn.getinterfacesummary(accessToken,startDate,endDate);
		if(result.isSuccess()){
			 List<InterAnlyseEntity> arrays = (List<InterAnlyseEntity>) result.getObj();
			 if(arrays.size()>0){
				 for(InterAnlyseEntity entity:arrays){
					 System.out.println(entity.toString());
					 System.out.println("----------------------------------------");
				 }
			 }
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//获取接口分析小时数据
	@Test
	public void testGetinterfacesummaryhour(){
		String startDate="2015-03-12";
		String endDate="2015-03-12";
		WechatResult result = conn.getinterfacesummaryhour(accessToken,startDate,endDate);
		if(result.isSuccess()){
			List<InterAnlyseEntity> arrays = (List<InterAnlyseEntity>) result.getObj();
			if(arrays.size()>0){
				for(InterAnlyseEntity entity:arrays){
					System.out.println(entity.toString());
					System.out.println("----------------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//获取消息发送概况数据(跨度 7 天)
	@Test
	public void testGetupstreammsgdistmonth(){
		String startDate="2015-02-10";
		String endDate="2015-02-20";
		WechatResult result = conn.getupstreammsgdistmonth(accessToken,startDate,endDate);
		if(result.isSuccess()){
			List<MsgAnalyseEntity> array = (List<MsgAnalyseEntity>) result.getObj();
			if(array.size()>0){
				for(MsgAnalyseEntity msg:array){
					System.out.println(msg.toString());
					System.out.println("--------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//获取消息分送分时数据(跨度 1 天)
	@Test
	public void testGetupstreammsghour(){
		String startDate="2015-02-10";
		String endDate="2015-02-10";
		WechatResult result = conn.getupstreammsghour(accessToken,startDate,endDate);
		if(result.isSuccess()){
			List<MsgAnalyseEntity> array = (List<MsgAnalyseEntity>) result.getObj();
			if(array.size()>0){
				for(MsgAnalyseEntity msg:array){
					System.out.println(msg.toString());
					System.out.println("--------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	//获取消息发送周数据
	@Test
	public void testGetupstreammsgweek(){
		String startDate="2015-03-09";
		String endDate="2015-03-14";
		WechatResult result = conn.getupstreammsgweek(accessToken,startDate,endDate);
		if(result.isSuccess()){
			List<MsgAnalyseEntity> array = (List<MsgAnalyseEntity>) result.getObj();
			if(array.size()>0){
				for(MsgAnalyseEntity msg:array){
					System.out.println(msg.toString());
					System.out.println("--------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	//获取消息发送月数据
	@Test
	public void testGetupstreammsgmonth(){
		String startDate="2015-02-01";
		String endDate="2015-02-18";
		WechatResult result = conn.getupstreammsgmonth(accessToken,startDate,endDate);
		if(result.isSuccess()){
			List<MsgAnalyseEntity> array = (List<MsgAnalyseEntity>) result.getObj();
			if(array.size()>0){
				for(MsgAnalyseEntity msg:array){
					System.out.println(msg.toString());
					System.out.println("--------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	//获取分布数据
	@Test
	public void testgetupstreammsgdist(){
		String startDate="2015-02-01";
		String endDate="2015-02-12";
		WechatResult result = conn.getupstreammsgdist(accessToken,startDate,endDate);
		if(result.isSuccess()){
			List<MsgAnalyseEntity> array = (List<MsgAnalyseEntity>) result.getObj();
			if(array.size()>0){
				for(MsgAnalyseEntity msg:array){
					System.out.println(msg.toString());
					System.out.println("--------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	//测试分布周数据
	@Test
	public void testGetupstreammsgdistweek(){
		String startDate="2015-03-09";
		String endDate="2015-03-14";
		WechatResult result = conn.getupstreammsgdistweek(accessToken,startDate,endDate);
		if(result.isSuccess()){
			List<MsgAnalyseEntity> array = (List<MsgAnalyseEntity>) result.getObj();
			if(array.size()>0){
				for(MsgAnalyseEntity msg:array){
					System.out.println(msg.toString());
					System.out.println("--------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	//息发送分布月数据
	@Test
	public void testwGetupstreammsgdistmonth(){
		String startDate="2015-02-01";
		String endDate="2015-02-25";
		WechatResult result = conn.getupstreammsgdistmonth(accessToken,startDate,endDate);
		if(result.isSuccess()){
			List<MsgAnalyseEntity> array = (List<MsgAnalyseEntity>) result.getObj();
			if(array.size()>0){
				for(MsgAnalyseEntity msg:array){
					System.out.println(msg.toString());
					System.out.println("--------------------------------");
				}
			}
		}else{
			System.out.println(result.getObj().toString());
		}
	}
}
