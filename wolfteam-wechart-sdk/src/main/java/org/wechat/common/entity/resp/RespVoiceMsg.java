package org.wechat.common.entity.resp;

import org.wechat.common.entity.resp.bean.Voice;

/**
 * 回复语音消息
 * 
 * @author Andy
 * 
 */
public class RespVoiceMsg extends RespBasicMsg {
	private Voice voice;

	@Override
	public String setMsgType() {
		return "voice";
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
}
