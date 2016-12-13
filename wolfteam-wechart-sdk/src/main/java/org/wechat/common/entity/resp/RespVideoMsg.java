package org.wechat.common.entity.resp;

import org.wechat.common.entity.resp.bean.Video;

public class RespVideoMsg extends RespBasicMsg {
	private Video video;

	@Override
	public String setMsgType() {
		return "video";
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}
