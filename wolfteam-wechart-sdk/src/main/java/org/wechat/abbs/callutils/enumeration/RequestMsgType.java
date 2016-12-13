package org.wechat.abbs.callutils.enumeration;

/**
 *
 * @ClassName: RequestMsgType
 * @Description: 微信请求类型 
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年11月28日   下午6:20:54
 *
 * @version 1.0 
 *  
 */
public enum RequestMsgType {
	TEXT(1, "text", "文本"),
	EVENT(2, "event", "事件推送。事件类型，subscribe(订阅)、unsubscribe(取消订阅)、CLICK(自定义菜单点击事件)"),
	IMAGE(3, "image", "图片"),
	LOCATION(4, "location", "地理位置"),
	LINK(5, "link", "链接消息"),
	SUBSCRIBE(6, "subscribe", "关注"),
	VOICE(7, "voice", "声音消息"),
	URL(8, "url", "跳转地址");

	private Integer type;
	private String value;
	private String desc;
	
	private RequestMsgType(Integer type, String value, String desc) {
		this.type = type;
		this.value = value;
		this.desc = desc;
	}
	
	public static RequestMsgType getByValue(String value) {
		for(RequestMsgType rt : RequestMsgType.values()) {
			if(rt.getValue().equals(value))
				return rt;
		}
		throw new RuntimeException("unknown value of request Msgtype.");
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}