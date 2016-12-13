package org.wechat.device.response;

import org.wechat.common.entity.results.ResultState;

/**
 * 摇一摇中新增页面返回的结果
 * 
 * @author Andy
 * 
 */
public class PagerResponse extends ResultState {
	private PageResult data;

	public PageResult getData() {
		return data;
	}

	public void setData(PageResult data) {
		this.data = data;
	}
}
