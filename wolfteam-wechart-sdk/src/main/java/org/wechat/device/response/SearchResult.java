package org.wechat.device.response;

import org.wechat.common.entity.results.ResultState;

/**
 * 搜索设备时返回的结果
 * 
 * @author Andy
 * 
 */
public class SearchResult extends ResultState {
	private DevicesData data;

	public DevicesData getData() {
		return data;
	}

	public void setData(DevicesData data) {
		this.data = data;
	}
}
