package org.wechat.common.entity.req;

public class TextMsg extends BasicMsg{
	private String Content;		//文本消息
	
	public String getContent() {
		return Content;
	}
	
	public void setContent(String content) {
		Content = content;
	}
	
	@Override
	public String SetMsgType() {
		return "text";
	}

}
