package org.wechat.menu.entity;

/**
 * 系统拍照发图
 * 
 * @author Andy
 * 
 */
public class PicSysphoto extends BasicMenu {
	private String key;
	private String sub_button[] = new String[]{};
	private String type =Menu.PIC_SYSPHOTO;

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
