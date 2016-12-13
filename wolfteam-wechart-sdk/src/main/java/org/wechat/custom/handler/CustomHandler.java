package org.wechat.custom.handler;

import org.wechat.custom.entity.ImageCustom;
import org.wechat.custom.entity.MusicCustom;
import org.wechat.custom.entity.NewsCustom;
import org.wechat.custom.entity.TextCustom;
import org.wechat.custom.entity.VideoCustom;
import org.wechat.custom.entity.VoiceCustom;

import com.alibaba.fastjson.JSONObject;

/**
 * 客服消息处理类
 * @author Andy
 *
 */
public class CustomHandler {
	
	/**
	 * 文本客服消息
	 * @param text	文本消息客服实体 	
	 * @return
	 */
	public static String toTextJson(TextCustom text){
		return JSONObject.toJSONString(text,true);
	}
	
	/**
	 * 图片客服消息
	 * @param image 图片客服消息实体
	 * @return
	 */
	public static String toImageJson(ImageCustom image){
		return JSONObject.toJSONString(image,true);
	}
	
	/**
	 * 语音客服消息
	 * @param voice
	 * @return
	 */
	public static String toVoiceJson(VoiceCustom voice){
		return JSONObject.toJSONString(voice, true);
	}
	
	/**
	 * 视频客服消息
	 * @param video
	 * @return
	 */
	public static String toVideoJson(VideoCustom video){
		return JSONObject.toJSONString(video, true);
	}
	
	/**
	 * 音乐消息
	 * @param music
	 * @return
	 */
	public static String toMusicJson(MusicCustom music){
		return JSONObject.toJSONString(music,true);
	}
	
	/**
	 * 多图文消息
	 * @param news
	 * @return
	 */
	public static String toNewsJson(NewsCustom news){
		return JSONObject.toJSONString(news, true);
	}
}
