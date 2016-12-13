package org.wechat.custom.entity;

/**
 * 视频客服消息
 * 
 * @author Andy
 * 
 */
public class VideoCustom extends BasicMsg {
	private CVideo video;

	@Override
	public String setMsgtype() {
		return "video";
	}

	public CVideo getVideo() {
		return video;
	}

	public void setVideo(CVideo video) {
		this.video = video;
	}

}
