package org.wechat.common.entity.event;

/**
 * 自定义菜单点击事件
 * 
 * @author Andy
 * 
 */
public class ClickEvent extends BasicEvent {
	private String EventKey; // 事件KEY值，与自定义菜单接口中KEY值对应

	@Override
	public String setEvent() {
		return "CLICK";
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
