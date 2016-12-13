package org.wechat.msg.test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.msg.conn.MessageConn;
import org.wechat.msg.entity.NewsEntity;
import org.wechat.msg.result.MsgResult;
import org.wechat.msg.result.SendStatus;
import org.wechat.msg.result.UploadNews;

import com.alibaba.fastjson.JSONObject;

/**
 * 测试
 * @author Andy
 *
 */
public class TestMsgConn {
	private MessageConn conn;
	private String accessToken="";
	@Before
	public void init(){
		conn = new MessageConn();
		accessToken = "Su-74MqRE3NfdjaP-3Q2fhfWRx0-4LO4-240-B1GRB0eEHg9vpkKwgNvqeJGzHYvlHLXmOsr2y6gI4IAHd7rLLGKxv8nwHY2eNW2v9-nJlA";
	}
	
	/**
	 * 测试设置模板消息
	 * (每个月可以修改一次)
	 */
	@Test
	public void testSetTempleate(){
	   MsgResult result = conn.setTempleate(accessToken,"14","15");
	   System.out.println("errCode-->"+result.getErrcode()+"\n"+"errMsg->"+result.getErrmsg());
	   Assert.assertNotNull(result);
	}
	
	/**
	 * 获取模板消息的id
	 *  errCode-->0
		errMsg->ok
		template_id-->ENSKygTrrWWpeWJ3WUowSQidOi5IxtvtSg0wBrTzUp8
	 */
	@Test
	public void testGetTemplateId(){
		MsgResult result = conn.getTemplateId(accessToken,"TM00235");
		System.out.println("errCode-->"+result.getErrcode()+"\n"+"errMsg->"+result.getErrmsg()+"\ntemplate_id-->"+result.getTemplate_id());
		Assert.assertNotNull(result);
	}
	
	/**
	 * 群发图片消息
	 * 0  send job submission success
	 */
	@Test
	public void testPostSendAllImage(){
		String mediaId = "2Ey_-ZPZgJXx2qMZMLk8MczGoVk6v7-j-QNP2-aKBAyzqOwZXfGUw-euPMm-tEH7";
		MsgResult result = conn.postSendAllImage(accessToken,false,100,mediaId);
		System.out.println(result.getErrcode());
		System.out.println(result.getErrmsg());
	}
	
	/**
	 * 测试群发文字消息
	 * 发送成功显示
	 * getErrcode() == 0 
	   getErrmsg() =  send job submission success
	 */
	@Test
	public void testPostSendAllText(){
		MsgResult result = conn.postSendallText(accessToken, true, 1,"---");
		System.out.println(result.getErrcode());
		System.out.println(result.getErrmsg());
		System.out.println(result.getMsgid());
	}
	
	/**
	 * 测试群发图文消息 (2000) C3GVN3B0Fs8yo7cvcQgwx6wIkhjrxdYkyGeMsnHDXR0lR8IWpGARkjLZN2BMXM10
	 * 如果 is_to_all ==true  参数 groupId 无效
	 * 如果 is_to_all ==false  按照groupId 分组id 发送消息
	 */
	@Test
	public void testPostSendallNews(){
		String mediaId = "C3GVN3B0Fs8yo7cvcQgwx6wIkhjrxdYkyGeMsnHDXR0lR8IWpGARkjLZN2BMXM10";
		int groupId = 1;
		MsgResult reuslt = conn.postSendallNews(accessToken,false, 100, mediaId);
		System.out.println(reuslt.getErrcode());
		System.out.println(reuslt.getErrmsg());
		System.out.println(reuslt.getMsgid());
	}
	
	/**
	 * 测试群发视频消息(未测试)
	 * 如果 is_to_all ==true  参数 groupId 无效
	 * 如果 is_to_all ==false  按照groupId 分组id 发送消息
	 */
	@Test
	public void testPostSendallVideo(){
		boolean is_to_all=false;
		String mediaId = "";
		String title = "";
		String descrption="";
		int groupId =0;
		MsgResult reuslt = conn.postSendAllVideo(accessToken, is_to_all, groupId, mediaId, title, descrption);
		System.out.println(reuslt.getErrcode());
		System.out.println(reuslt.getErrmsg());
		System.out.println(reuslt.getMsgid());
	}
	
	/**
	 * 测试群发语音消息(未测试)
	 * 如果 is_to_all == true  参数 groupId 无效
	 * 如果 is_to_all == false  按照groupId 分组id 发送消息
	 */
	@Test
	public void testPostSendAllVoice(){
		boolean is_to_all=false;
		String mediaId = "";
		int groupId =0;
		MsgResult result = conn.postSendAllVoice(accessToken, is_to_all, groupId, mediaId);
		System.out.println(result.getErrcode());
		System.out.println(result.getErrmsg());
		System.out.println(result.getMsgid());
	}
	
	/**
	 * 通过openid 群发发送文本消息
	 */
	@Test
	public void testSendByOpenIdOfText(){
		List<String> params = new ArrayList<String>();
		params.add("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		String conetent = "单独测试发送";
		MsgResult result = conn.sendByOpenIdOfText(accessToken,params,conetent);
		System.out.println(result.getErrcode());
		System.out.println(result.getErrmsg());
		System.out.println(result.getMsgid());
	}
	
	/**
	 * 通过openid群发图片消息
	 * errcode=0, errmsg=send job submission success, msg_id=2352271077
	 * [errcode=0, errmsg=send job submission success, msg_id=2352271100
	 */
	@Test
	public void testSendByOpenIdOfImage(){
		List<String> params = new ArrayList<String>();
		params.add("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		params.add("oZq7Bt65BpxaS8MaRSkNKcOruXio");
		String mediaId = "";
		MsgResult result = conn.sendByOpenIdOfImage(accessToken,params, mediaId);
		System.out.println(result.toString());
	}
	
	
	/**
	 * 预览发送图片消息
	 */
	@Test
	public void testPrepareImage(){
		String openId  = "oZq7BtxHTUfedo4CNMrVHPVF2ZgU";
		String mediaId = "2Ey_-ZPZgJXx2qMZMLk8MczGoVk6v7-j-QNP2-aKBAyzqOwZXfGUw-euPMm-tEH7";
		MsgResult result = conn.prepareImage(accessToken, openId, mediaId);
		System.out.println(result.toString());
	}
	
	/**
	 * 预览图文消息
	 * 
	 */
	@Test
	public void testPrepareNews(){
		String openId = "oZq7BtxHTUfedo4CNMrVHPVF2ZgU";
		String mediaId = "C3GVN3B0Fs8yo7cvcQgwx6wIkhjrxdYkyGeMsnHDXR0lR8IWpGARkjLZN2BMXM10";				//
		MsgResult result = conn.prepareNews(accessToken, openId, mediaId);
		System.out.println(result.toString());
	}
	
	/**
	 * 预览文字消息
	 */
	@Test
	public void testPreparedText(){
		String openId = "oZq7BtxHTUfedo4CNMrVHPVF2ZgU";
		String content = "测试预览消息";
		MsgResult result = conn.prepareText(accessToken, openId, content);
		System.out.println(result.toString());
	}
	
	/**
	 * 预览视频消息
	 */
	@Test
	public void testPrepareVideo(){
		String openId = "oZq7BtxHTUfedo4CNMrVHPVF2ZgU";
		String mediaId = "";
		MsgResult result = conn.prepareVideo(accessToken, openId,mediaId);
		System.out.println(result.toString());
	}
	
	/**
	 * 预览语言消息
	 */
	@Test
	public void testPrepareVoice(){
		String openId = "oZq7BtxHTUfedo4CNMrVHPVF2ZgU";
		String mediaId = "";
		MsgResult result = conn.prepareVoice(accessToken, openId, mediaId);
		System.out.println(result.toString());
	}
	
	/**
	 * 删除群发消息id
	 */
	@Test
	public void testDeleteGroupSendMsg(){
		String msgId = "2352315333";
		MsgResult result = conn.deleteSend(accessToken, msgId);
		System.out.println(result.toString());
	}
	
	/**
	 * 查看群发状态
	 */
	@Test
	public void testSendState(){
		String msgId = "2352315333";
		SendStatus status = conn.getSendState(accessToken,msgId);
		System.out.println(status.getMsg_id());
		System.out.println(status.getMsg_status());
	}
/****************************************************************************************************************/
 
	
	
	
	//测试群发的消息参数
	@Test
	public void testPostText(){
		String data = postSendallText(false,1,"content");
		System.out.println(data);
	}
	/**
	 * 按照openid来群发图文消息
	 * @param list	  用户openid集合
	 * @param mediaId	 mediaId;
	 * @param msgtype
	 * @return
	 */
	private String sendByOpenIdOfNews(List<String> list,String mediaId){
		TreeMap<String,Object> params = new TreeMap<String,Object>();
		params.put("touser", list);
		//list Params
		TreeMap<String,String> medaidParams = new TreeMap<String,String>();
		medaidParams.put("media_id", mediaId);
		params.put("mpnews", medaidParams);
		params.put("msgtype","mpnews");
		String data = JSONObject.toJSONString(params,true);
		return data;
	}
	
	/**
	 * 按照分组发送的文本消息
	 * @param is_to_all
	 * @param groupId
	 * @param coentent
	 * @return
	 */
	private String postSendallText(boolean is_to_all,int groupId,String coentent){
		TreeMap<String,Object> obj = new TreeMap<String,Object>();
		TreeMap<String,Object> params = new TreeMap<String,Object>();
		params.put("is_to_all",is_to_all);
		params.put("group_id",groupId);
		obj.put("filter", params);
		//
		TreeMap<String,Object> newsParasm = new TreeMap<String,Object>();
		newsParasm.put("content",coentent);
		obj.put("text", newsParasm);
		obj.put("msgtype", "text");
		//
		String jsonData = JSONObject.toJSONString(obj,false);
		return jsonData;
	}
	
	/*测试发送图文消息
	* C3GVN3B0Fs8yo7cvcQgwx6wIkhjrxdYkyGeMsnHDXR0lR8IWpGARkjLZN2BMXM10
	* */
	@Test
	public void testUploadnews(){
		List<NewsEntity> array = new ArrayList<NewsEntity>();
		NewsEntity entity = new NewsEntity();
		entity.setAuthor("authoer");
		entity.setContent("Content");
		entity.setContent_source_url("http://www.baidu.com");
		entity.setDigest("digest");
		entity.setShow_conver_pic(1);
		entity.setThumb_media_id("otW4BIszBN_Z9hmjKvvRfIjbBjoWIRyAk2LbiJJ3audoTLl6_sMgJzF6jlUW9tf0");
		entity.setTitle("title");
		array.add(entity);
		WechatResult result = conn.uploadnews(accessToken, array);
		if(result.isSuccess()){
			UploadNews news = (UploadNews) result.getObj();
			System.out.println(news.getMedia_id());
		}
	}
}
