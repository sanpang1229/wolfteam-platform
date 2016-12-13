package org.wechat.device.response;

import org.wechat.common.entity.results.ResultState;

/**
 * 申请设备少于500时的对象
 * @author Andy
 * 
 */
public class Less500Result extends ResultState {
	private GreaterResult data;

	public GreaterResult getData() {
		return data;
	}

	public void setData(GreaterResult data) {
		this.data = data;
	}
}
