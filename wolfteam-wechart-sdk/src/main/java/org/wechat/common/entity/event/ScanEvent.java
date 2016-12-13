package org.wechat.common.entity.event;

/**
 * 用户已关注事件
 * 
 * @author Andy
 */
public class ScanEvent extends BasicEvent {
	private String EventKey; // 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	private String Ticket; // 二维码的ticket，可用来换取二维码图片

	@Override
	public String setEvent() {
		return "SCAN";
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

}
