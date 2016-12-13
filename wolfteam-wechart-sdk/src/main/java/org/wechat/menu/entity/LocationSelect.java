package org.wechat.menu.entity;

/**
 * 发送位置
 * 
 * @author Andy
 * 
 */
public class LocationSelect extends BasicMenu {
	private String key;
	private String type=Menu.LOCATION_SELECT;

	
	public String getType() {
		return type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
