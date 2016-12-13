package org.wechat.device.response;

import org.wechat.device.request.DeviceIdentifier;

/**
 * 搜索设备列表时出现的结果
 * @author Andy
 * 
 */
public class DeviceItem extends DeviceIdentifier {
	private String comment;
	private String page_ids;
	private int status;
	private int poi_id;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPage_ids() {
		return page_ids;
	}

	public void setPage_ids(String pageIds) {
		page_ids = pageIds;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPoi_id() {
		return poi_id;
	}

	public void setPoi_id(int poiId) {
		poi_id = poiId;
	}
}
