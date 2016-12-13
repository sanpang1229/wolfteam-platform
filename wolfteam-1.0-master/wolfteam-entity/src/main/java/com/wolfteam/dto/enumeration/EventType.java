package com.wolfteam.dto.enumeration;



/**
 *
 * @ClassName: EventType
 * @Description: 微信请求事件类型MsgType
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月29日 下午3:05:03
 * 
 * @version 1.0 
 *  
 */

public enum EventType {
	LOCATION(1, "LOCATION", "上报地理位置事件"),
	subscribe(10, "subscribe", "订阅"),
	click(2, "CLICK", "点击菜单拉取消息的事件推送"),
	view(3, "VIEW", "点击菜单跳转链接的事件推送"),
	scancode_push(4, "scancode_push", "扫码推事件的事件推送"),
	scancode_waitmsg(5, "scancode_waitmsg", "扫码推事件且弹出“消息接收中”提示框的事件推送"),
	pic_sysphoto(6, "pic_sysphoto", "弹出系统拍照发图的事件推送"),
	pic_photo_or_album(7, "pic_photo_or_album", "弹出拍照或者相册发图的事件推送"),
	pic_weixin(8, "pic_weixin", "弹出微信相册发图器的事件推送"),
	location_select(9, "location_select", "弹出地理位置选择器的事件推送"),
	unsubscribe(11, "unsubscribe", "取消订阅"),
	enter_agent(12,"enter_agent","进入应用");
	 
	private Integer type;
	private String value;
	private String desc;
	
	private EventType(Integer type, String value, String desc) {
		this.type = type;
		this.value = value;
		this.desc = desc;
	}
	
	public static EventType getByValue(String value) {
		for(EventType rt : EventType.values()) {
			if(rt.getValue().equals(value))
				return rt;
		}
		System.out.println(value);
		throw new RuntimeException("unknown value of request type.");
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
