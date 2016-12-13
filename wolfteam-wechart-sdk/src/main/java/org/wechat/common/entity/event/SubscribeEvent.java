package org.wechat.common.entity.event;

/**
 * 关注事件
 * 
 * @author Andy
 * 
 */
public class SubscribeEvent extends BasicEvent {
	private String EventKey; // 事件KEY值，qrscene_为前缀，后面为二维码的参数值
	private String Ticket; // 二维码的ticket，可用来换取二维码图片

	@Override
	public String setEvent() {
		return "subscribe";
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
