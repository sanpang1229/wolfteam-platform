package org.wechat.menu.entity;

/**
 * 扫码推事件且弹出“消息接收中”提示框
 * 
 * @author Andy
 * 
 */
public class WaitMsg extends BasicMenu {
	private String key;
	private String sub_button[]= new String[]{};
	private String type =Menu.SCANCODE_WAITMSG;

	public String getType() {
		return type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String[] getSub_button() {
		return sub_button;
	}
}
