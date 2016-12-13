package org.wechat.menu.entity;

/**
 * 所有属性
 * 
 * @author Andy
 * 
 */
public class MenuAllInfo extends BasicMenu {
	private String type;
	private String url;
	private String key;
	private String sub_button;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSub_button() {
		return sub_button;
	}

	public void setSub_button(String subButton) {
		sub_button = subButton;
	}

}