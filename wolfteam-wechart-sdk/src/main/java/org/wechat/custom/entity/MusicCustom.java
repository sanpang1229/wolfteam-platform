package org.wechat.custom.entity;

import org.wechat.common.entity.resp.bean.Music;

/**
 * 音乐客服消息
 * 
 * @author Andy
 * 
 */
public class MusicCustom extends BasicMsg {
	private Music music;

	@Override
	public String setMsgtype() {
		return "music";
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

}
