package org.wechat.common.handler;

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
import org.wechat.common.utils.XStreamFactory;
import org.wechat.pay.request.BasicPayParams;

import com.thoughtworks.xstream.XStream;

/**
 * 消息处理类
 * @author Andy
 *
 */
public class MsgHandler {
	
	/**
	 * 文本消息
	 * @param text
	 * @return
	 */
	public static String TextMsg(RespTextMsg text){
		String result="";
		if(text!=null){
			XStream xs = XStreamFactory.init(true);
			xs.alias("xml", RespTextMsg.class);
			result = xs.toXML(text);
		}
		return result;
	}
	
	/**
	 * 图片消息
	 * @param image
	 * @return
	 */
	public static String ImageMsg(RespImgMsg image){
		String result="";
		if(image!=null){
			XStream xs = XStreamFactory.init(true);
			xs.alias("xml", RespImgMsg.class);
			xs.aliasField("Image", Image.class,"image");
			result = xs.toXML(image);
		}
		return result;
	}
	
	/**
	 * 音乐消息
	 * @param music
	 * @return
	 */
	public static String MusicMsg(RespMusicMsg music){
		String result="";
		if(music!=null){
		  XStream xs = XStreamFactory.init(true);
		  xs.alias("xml",RespMusicMsg.class);
		  xs.aliasField("Music", Music.class, "music");
		  result=xs.toXML(music);
		}
		return result;
	}
	
	/**
	 * 图文消息
	 * @param news
	 * @return
	 */
	public static String NewsMsg(RespNewsMsg news){
		String result="";
		if(news!=null){
		  XStream xs = XStreamFactory.init(true);
		  xs.alias("xml",RespNewsMsg.class);
		  xs.addImplicitCollection(Articles.class,"list", "item", Item.class);
		  xs.aliasField("Articles", RespNewsMsg.class,"articles");
		  result = xs.toXML(news);
		}
		return result;
	}
	
	/**
	 * 视频消息
	 * @param news
	 * @return
	 */
	public static String VideoMsg(RespVideoMsg video){
		String result="";
		if(video!=null){
			XStream xs = XStreamFactory.init(true);
			xs.alias("xml",RespVideoMsg.class);
			xs.aliasField("Video",Video.class,"video");
			result = xs.toXML(video);
		}
		return result;
	}
	
	/**
	 * 语音消息
	 * @param voice
	 * @return
	 */
	public static String VoiceMsg(RespVoiceMsg voice){
		String result="";
		if(voice!=null){
			XStream xs = XStreamFactory.init(true);
			xs.alias("xml",RespVoiceMsg.class);
			xs.aliasField("Voice", Voice.class,"voice");
			result = xs.toXML(voice);
		}
		return result;
	}
}
