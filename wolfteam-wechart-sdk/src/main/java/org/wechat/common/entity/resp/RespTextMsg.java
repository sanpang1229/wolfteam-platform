package org.wechat.common.entity.resp;

public class RespTextMsg extends RespBasicMsg {
	private String Content;

	@Override
	public String setMsgType() {
		return "text";
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
