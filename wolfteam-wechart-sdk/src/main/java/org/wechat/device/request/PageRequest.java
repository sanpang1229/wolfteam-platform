package org.wechat.device.request;

/**
 * page对象
 * 
 * @author Andy
 * 
 */
public class PageRequest {
	private String title; // 在摇一摇页面展示的主标题，不超过6个字
	private String description; // 在摇一摇页面展示的副标题，不超过7个字
	private String page_url; // 页面显示的url
	private String comment; // 页面的备注信息，不超过15个字
	private String icon_url; // 在摇一摇页面展示的图片。图片需先上传至微信侧服务器，用“素材管理-上传图片素材”接口上传图片，返回的图片URL再配置在此处

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPage_url() {
		return page_url;
	}

	public void setPage_url(String pageUrl) {
		page_url = pageUrl;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String iconUrl) {
		icon_url = iconUrl;
	}
}