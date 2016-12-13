package org.wechat.device.response;

import org.wechat.common.entity.results.ResultState;

/**
 * 大于500的结果类型
 * 
 * @author Andy
 */
public class ApplyResult extends ResultState {
	private Apply data;

	public Apply getData() {
		return data;
	}

	public void setData(Apply data) {
		this.data = data;
	}
}
