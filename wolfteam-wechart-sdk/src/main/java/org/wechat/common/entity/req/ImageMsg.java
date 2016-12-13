package org.wechat.common.entity.req;

/**
 * 图片消息
 * 
 * @author Andy
 * 
 */
public class ImageMsg extends BasicMsg {
	private String PicUrl; // 图片链接
	private String MediaId; // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。

	@Override
	public String SetMsgType() {
		return "image";
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
