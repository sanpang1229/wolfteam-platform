package org.wechat.custom.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.wechat.common.entity.resp.bean.Articles;
import org.wechat.common.entity.resp.bean.Image;
import org.wechat.common.entity.resp.bean.Item;
import org.wechat.common.entity.resp.bean.Music;
import org.wechat.common.entity.resp.bean.Text;
import org.wechat.common.entity.resp.bean.Voice;
import org.wechat.common.entity.results.JsonResult;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.custom.conn.CustomConn;
import org.wechat.custom.entity.CVideo;
import org.wechat.custom.entity.ImageCustom;
import org.wechat.custom.entity.MusicCustom;
import org.wechat.custom.entity.News;
import org.wechat.custom.entity.NewsCustom;
import org.wechat.custom.entity.SessionEntity;
import org.wechat.custom.entity.TextCustom;
import org.wechat.custom.entity.VideoCustom;
import org.wechat.custom.entity.VoiceCustom;
import org.wechat.custom.entity.results.OnLineSession;

/**
 * 测试CustomConn
 * @author Andy
 *
 */
public class TestCustomConn {
	private CustomConn conn;
	private String accessToken="";
	
	@Before
	public void initConn(){
		conn = new CustomConn();
		accessToken = "nQekzIcGqomU5TT_mdB42wT_wRwTFPItw2UKD5-NmuPizLEVY2eZjAQ_Kf38KKvKFY4phxeBTWS1162xyi-VsCZht1GEEG4t1jAytrUHI0E";
	}
	/**
	 * 测试添加客服
	 */
	@Test
	public void testAddCustom(){
		try{
			JsonResult msg = conn.addCustom(accessToken, "11099@sq56weixin","Andy", "test");
		System.out.println(msg.getErrcode()+"---->"+msg.getErrmsg());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 测试修改客服信息
	 */
	@Test
	public void testUpdateCustom(){
		try{
			JsonResult msg = conn.updateCustomInfo(accessToken, "11099@sq56weixin","AndyWEWEW", "test");
		System.out.println(msg.getErrcode()+"---->"+msg.getErrmsg());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 删除客服消息
	 * 0---->no error
	 */
	@Test
	public void testDeleteCustom(){
		try{
			JsonResult msg = conn.deleteCustom(accessToken, "11099@sq56weixin");
		System.out.println(msg.getErrcode()+"---->"+msg.getErrmsg());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 测试查询客服消息
	 */
	@Test
	public void testGetCustomRecord(){
		
	}
	
	/**
	 * 获取客服信息
	 * {"kf_list":[{"kf_account":"11099@sq56weixin","kf_nick":"Andy","kf_id":"1001","kf_headimgurl":""}]}
	 */
	@Test
	public void testGetCustomInfo(){
		String result = conn.getCustomInfo(accessToken);
		Assert.assertNotNull(result);
		System.out.println(result);
	}
	
	/**
	 * 获取在线接待信息
	 * {"kf_online_list":[]}
	 */
	@Test
	public void testGetOnLinekFlist(){
		String result = conn.getOnLinekFlist(accessToken);
		assertNotNull(result);
		System.out.println(result);
	}
	
	/**
	 * 测试上传客服头像(通过测试)
	 * 0  no error
	 */
	@Test
	public void testUploadHeadImg(){
		String kfAccount="11099@sq56weixin";
		String mediaPath="https://www.baidu.com/img/bdlogo.png";
		JsonResult result = conn.uploadCustomHeadImg(accessToken, kfAccount, mediaPath);
		System.out.println(result.getErrcode());
		System.out.println(result.getErrmsg());
		assertNotNull(result);
	}
	
	/**
	 * 测试发送文本客服消息
	 * {"errcode":0,"errmsg":"ok"}
	 */
	@Test
	public void testSendCustomOfTextMsg(){
		TextCustom txtCustom = new TextCustom();
		txtCustom.setTouser("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		Text text = new Text();
		text.setContent("测试发送文本客服消息");
		txtCustom.setText(text);
		JsonResult result = conn.sendCustomOfTextMsg(accessToken,txtCustom);
		System.out.println(result.getErrcode()+" "+result.getErrmsg());
	}
	
	/**
	 * 测试发送图片客服消息
	 * (通过测试)
	 */
	@Test
	public void testSendCustomofImageMsg(){
		ImageCustom imageCustom = new ImageCustom();
		imageCustom.setTouser("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		Image image = new Image();
		image.setMedia_id("1fSa0bBL-KGMoCROTbkACMupqqAJd4TI2jeMZUBQpqURb8DymLYkV-9XxkGzKLU0");
		imageCustom.setImage(image);
		JsonResult result = conn.sendCustomofImageMsg(accessToken, imageCustom);
		System.out.println(result.getErrcode()+" "+result.getErrmsg());
	}
	
	/**
	 * 测试发送语言客服消息
	 * (待测试)
	 */
	@Test
	public void testSendCustomOfVoice(){
		VoiceCustom voiceCustom = new VoiceCustom();
		voiceCustom.setTouser("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		Voice voice = new Voice();
		voice.setMedia_id("1fSa0bBL-KGMoCROTbkACMupqqAJd4TI2jeMZUBQpqURb8DymLYkV-9XxkGzKLU0");
		voiceCustom.setVoice(voice);
		JsonResult result = conn.sendCustomOfVoice(accessToken, voiceCustom);
		System.out.println(result.getErrcode()+" "+result.getErrmsg());
	}
	
	/**
	 * 测试发送视频客服消息
	 * (待测试)
	 */
	@Test
	public void testSendCustomOfVideo(){
		VideoCustom videoCustom = new VideoCustom();
		videoCustom.setTouser("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		CVideo video = new CVideo();
		video.setDescription("描述");
		video.setMediaId("mediaId");
		video.setThumb_media_id("thumb_media_id");
		video.setTitle("title");
		videoCustom.setVideo(video);
		JsonResult result = conn.sendCustomOfVideo(accessToken, videoCustom);
		System.out.println(result.getErrcode()+" "+result.getErrmsg());
	}

	/**
	 * 测试发送音乐客服消息
	 */
	@Test
	public void testSendCustomMusic(){
		MusicCustom musicCustom = new MusicCustom();
		Music music = new Music();
		music.setDescription("Description");
		music.setHQMusicUrl("HQMusicUrl");
		music.setMusicURL("musicUrl");
		music.setThumbMediaId("THUMBmEDIA");
		music.setTitle("title");
		musicCustom.setMusic(music);
		musicCustom.setTouser("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		JsonResult result = conn.sendCustomOfMusic(accessToken, musicCustom);
		System.out.println(result.getErrcode()+" "+result.getErrmsg());
	}
	
	/**
	 * 发送图文客服消息
	 * (未通过测试)
	 */
	@Test
	public void testSendCustomOfNews(){
		NewsCustom newsCustom = new NewsCustom();
		newsCustom.setTouser("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		News newsc = new News();
		Articles  articles = new Articles();
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setDescription("description");
		item.setPicUrl("picUrl");
		item.setTitle("title");
		item.setUrl("url");
		articles.setList(items);
		newsc.setArticles(articles);
		newsCustom.setNews(newsc);
		JsonResult result = conn.sendCustomOfNews(accessToken, newsCustom);
		System.out.println(result.getErrcode()+" "+result.getErrmsg());
	}
	
	/**
	 * 创建多客服会话 (未通过测试)
	 * 61459 kf offline  表示该客户处于离线状态
	 */
	@Test
	public void testCreateSession(){
		SessionEntity entity = new SessionEntity();
		entity.setKf_account("11099@sq56weixin");
		entity.setOpenid("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		entity.setText("创建多客户会话");
		JsonResult result = conn.createSession(accessToken, entity);
		System.out.println(result.getErrcode()+" "+result.getErrmsg());
	}
	
	/**
	 * 关闭一个会话(未完成测试)
	 */
	@Test
	public void testCloseSession(){
		SessionEntity entity = new SessionEntity();
		entity.setKf_account("11099@sq56weixin");
		entity.setOpenid("oZq7BtxHTUfedo4CNMrVHPVF2ZgU");
		entity.setText("关闭一个会话");
		JsonResult result = conn.closeSession(accessToken, entity);
		System.out.println(result.getErrcode()+" "+result.getErrmsg());
	}
	
	/**
	 * 根据openid来获取会话的状态 (未通过测试)
	 * 0 session not exsited
	 */
	@Test
	public void testGetSessionStateByOpenId(){
		String openid = "oZq7BtxHTUfedo4CNMrVHPVF2ZgU";
		JsonResult result = conn.getSessionStateByOpenId(accessToken, openid);
		System.out.println(result.getErrcode()+" "+result.getErrmsg());
	}
	
	/**
	 * 根据客服账号获取当前客服会话列表 (未通过测试)
	 * {
    "errcode": 0,
    "errmsg": "no error",
    "sessionlist": [
    
    ]
}
	 */
	@Test
	public void testGetSessionListByKfaccount(){
		String kfaccount = "11099@sq56weixin";
		WechatResult result = conn.getSessionListByKfaccount(accessToken, kfaccount);
		if(result.isSuccess()){
			List<OnLineSession> list = (List<OnLineSession>) result.getObj();
			System.out.println(list.size());
		}else{
			System.out.println(result.getObj().toString());
		}
	}
	
	/**
	 * 查看未接入会话的列表
	 */
	@Test
	public void testGetWaitCase(){
			String result = conn.getWaitCase(accessToken);
			System.out.println(result);
	}
}
	
