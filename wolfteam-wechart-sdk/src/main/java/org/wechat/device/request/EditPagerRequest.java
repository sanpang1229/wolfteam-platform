package org.wechat.device.request;

/**
 * 编辑页面中发送请求的实体对象
 * 
 * @author Andy
 * 
 */
public class EditPagerRequest extends PageRequest {
	private long page_id; // 摇周边页面唯一ID

	public long getPage_id() {
		return page_id;
	}

	public void setPage_id(long pageId) {
		page_id = pageId;
	}
}
