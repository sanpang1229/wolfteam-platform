package org.wechat.common.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.wechat.common.entity.resp.RespImgMsg;
import org.wechat.common.entity.resp.RespMusicMsg;
import org.wechat.common.entity.resp.RespNewsMsg;
import org.wechat.common.entity.resp.RespTextMsg;
import org.wechat.common.entity.resp.RespVideoMsg;
import org.wechat.common.entity.resp.RespVoiceMsg;
import org.wechat.common.entity.resp.bean.Articles;
import org.wechat.common.entity.resp.bean.Image;
import org.wechat.common.entity.resp.bean.Item;
import org.wechat.common.entity.resp.bean.Music;
import org.wechat.common.entity.resp.bean.Video;
import org.wechat.common.entity.resp.bean.Voice;
import org.wechat.common.handler.BasicXmlHandler;
import org.wechat.common.handler.MsgHandler;
import org.wechat.common.handler.impl.BasicXmlHandlerImpl;
import org.wechat.common.utils.EncryptUtils;

/**
 * 测试 MsgHandler
 * @author Andy
 *
 */
public class TestMsgHandler {

	/**
	 * 测试
	 */
	@Test
	public void testHandlerImpl(){
		BasicXmlHandler handler = new BasicXmlHandlerImpl();
		RespTextMsg text = new RespTextMsg();
		text.setContent("内容");
		text.setFromUserName("fromUserName");
		text.setToUserName("toUser");
		text.setCreateTime(1);
		String result = handler.toMsgXml(text);
		System.out.print(result);
	}
	
	/**
	 * 文本消息
	 */
	@Test
	public void testTextMsg(){
		RespTextMsg text = new RespTextMsg();
		text.setContent("内容");
		text.setFromUserName("fromUserName");
		text.setToUserName("toUser");
		text.setCreateTime(1);
		System.out.println(MsgHandler.TextMsg(text));
		assertNotNull(MsgHandler.TextMsg(text));
	}
	
	/**
	 * 图片消息
	 */
	@Test
	public void testImageMsg(){
		RespImgMsg imagemsg = new RespImgMsg();
		imagemsg.setCreateTime(111);
		imagemsg.setFromUserName("forUserName");
		Image image = new Image();
		image.setMedia_id("mediaId");
		imagemsg.setImage(image);
		imagemsg.setToUserName("toUserName");
		System.out.println(MsgHandler.ImageMsg(imagemsg));
	}
	
	/**
	 * 音乐消息
	 */
	@Test
	public void testMusicMsg(){
		RespMusicMsg musicmsg = new RespMusicMsg();
		musicmsg.setCreateTime(111);
		musicmsg.setFromUserName("forUserName");
		musicmsg.setToUserName("toUserName");
		Music music = new Music();
		music.setDescription("description");
		music.setHQMusicUrl("HQMusicUrl");
		music.setThumbMediaId("ThumbMediaId");
		music.setTitle("title");
		musicmsg.setMusic(music);
		System.out.println(MsgHandler.MusicMsg(musicmsg));
	}
	
	/**
	 * 图文消息
	 */
	@Test
	public void testNewsMsg(){
		RespNewsMsg newsmsg = new RespNewsMsg();
		newsmsg.setArticleCount(1);
		newsmsg.setCreateTime(1);
		newsmsg.setFromUserName("formUsrName");
		newsmsg.setToUserName("toUserName");
		Item item = new Item();
		item.setDescription("description");
		item.setPicUrl("picUrl");
		item.setTitle("titile");
		item.setUrl("url");
		List<Item> list = new ArrayList<Item>();
		list.add(item);
		Articles articles= new Articles();
		articles.setList(list);
		newsmsg.setArticles(articles);
		System.out.println(MsgHandler.NewsMsg(newsmsg));
	}
	
	/**
	 * 视频消息
	 */
	@Test
	public void testVideoMsg(){
		RespVideoMsg videomsg = new RespVideoMsg();
		videomsg.setCreateTime(1211);
		videomsg.setFromUserName("formUserName");
		videomsg.setToUserName("toUserName");
		Video video = new Video();
		video.setDescription("Description");
		video.setMediaId("mediaId");
		video.setTitle("titile");
		videomsg.setVideo(video);
		System.out.println(MsgHandler.VideoMsg(videomsg));
	}
	
	/**
	 * 语音消息
	 */
	@Test
	public void testVoiceMsg(){
		RespVoiceMsg voiceMsg = new RespVoiceMsg();
		voiceMsg.setCreateTime(1212121);
		voiceMsg.setFromUserName("formName");
		voiceMsg.setToUserName("toUserName");
		Voice voice = new Voice();
		voice.setMedia_id("MediaId");
		voiceMsg.setVoice(voice);
		System.out.println(MsgHandler.VoiceMsg(voiceMsg));
	}
	
	/**
	 * 测试sha加密
	 */
	@Test
   public void testSAX(){
		String result = EncryptUtils.EncryptSHA1("123");
		System.out.println(result);
   }
}
