package org.wechat.common.entity.req;

/**
 * Link消息
 * 
 * @author Andy
 * 
 */
public class LinkMsg extends BasicMsg {
	private String Title; // 消息标题
	private String Description; // 消息描述
	private String Url; // 消息链接

	@Override
	public String SetMsgType() {
		return "link";
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
}
