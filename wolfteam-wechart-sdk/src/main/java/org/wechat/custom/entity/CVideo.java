package org.wechat.custom.entity;

import org.wechat.common.entity.resp.bean.Video;

/**
 * 客服消息中的视频消息
 * 
 * @author Andy
 * 
 */
public class CVideo extends Video {
	private String thumb_media_id; // 缩略图的媒体ID

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumbMediaId) {
		thumb_media_id = thumbMediaId;
	}

}
