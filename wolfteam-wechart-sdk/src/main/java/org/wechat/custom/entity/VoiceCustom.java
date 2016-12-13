package org.wechat.custom.entity;

import org.wechat.common.entity.resp.bean.Voice;

/**
 * 语言消息
 * 
 * @author Andy
 * 
 */
public class VoiceCustom extends BasicMsg {
	private Voice voice;

	@Override
	public String setMsgtype() {
		return "voice";
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

}
