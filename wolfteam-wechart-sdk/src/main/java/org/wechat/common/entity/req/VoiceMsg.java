package org.wechat.common.entity.req;

/**
 * 语音消息
 * 
 * @author Andy
 */
public class VoiceMsg extends BasicMsg {
	private String MediaId; // 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String Format; // 语音格式，如amr，speex等

	@Override
	public String SetMsgType() {
		return "voice";
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
}
