package org.wechat.custom.entity;

import org.wechat.common.entity.resp.bean.Text;

/**
 * 客服文本消息
 * @author Andy
 * 
 */
public class TextCustom extends BasicMsg {
	private Text text; // 文本消息对象

	@Override
	public String setMsgtype() {
		return "text";
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

}
