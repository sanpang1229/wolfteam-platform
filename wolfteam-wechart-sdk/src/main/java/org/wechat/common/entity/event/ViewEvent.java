package org.wechat.common.entity.event;

/**
 * 自定义菜单跳转链接
 * 
 * @author Andy
 * 
 */
public class ViewEvent extends BasicEvent {
	private String EventKey; // 事件KEY值，设置的跳转URL

	@Override
	public String setEvent() {
		return "VIEW";
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
