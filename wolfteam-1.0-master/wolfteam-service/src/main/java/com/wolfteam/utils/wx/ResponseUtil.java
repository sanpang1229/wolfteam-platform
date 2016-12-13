package com.wolfteam.utils.wx;

import java.util.List;

import com.wolfteam.dto.ResponseDTO;
import com.wolfteam.dto.enumeration.ResponseType;
import com.wolfteam.dto.wx.model.ArticleItem;
import com.wolfteam.dto.wx.resp.Image;
import com.wolfteam.dto.wx.resp.Voice;


public class ResponseUtil {

	/**
	 * 响应文本消息
	 * @param io
	 * @param content
	 */
	public static void responseText(ResponseDTO response, String content) {
		response.setMsgType(ResponseType.TEXT.toString());
		response.setContent(content);
	}
	
	/**
	 * 响应图文消息
	 * @param io
	 * @param content
	 */
	public static void responseNews(ResponseDTO response, List<ArticleItem> items) {
		response.setFuncFlag(1);
		response.setMsgType(ResponseType.NEWS.toString());
		response.setArticleCount(items.size());
		response.setItems(items);
	}
	/**
	 * 响应图片信息
	 * @param io
	 * @param content
	 */
	public static void responsePicInfo(ResponseDTO response, Image image) {
		response.setMsgType(ResponseType.IMAGE.toString());
		response.setImage(image);
	}
	/**
	 * 回复语音消息
	 * @param io
	 * @param content
	 */
	public static void responseVoicefo(ResponseDTO response, Voice voice) {
		response.setMsgType(ResponseType.VOICE.toString());
		response.setVoice(voice);
	}
}
