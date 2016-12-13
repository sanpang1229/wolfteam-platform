package org.wechat.common.entity.resp;

import org.wechat.common.entity.resp.bean.Music;

public class RespMusicMsg extends RespBasicMsg {
	private Music music;

	@Override
	public String setMsgType() {
		return "music";
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

}
