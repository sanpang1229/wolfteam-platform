package org.wechat.abbs.callutils.util;

import java.util.List;

import org.wechat.abbs.callutils.dto.ResponseDTO;
import org.wechat.abbs.callutils.dto.wx.model.ArticleItem;
import org.wechat.abbs.callutils.dto.wx.resp.Image;
import org.wechat.abbs.callutils.dto.wx.resp.Voice;
import org.wechat.abbs.callutils.enumeration.ResponseType;



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
