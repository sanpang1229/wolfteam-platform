package org.wechat.device.response;

import org.wechat.common.entity.results.ResultState;

/**
 * 获取摇周边的设备及用户信息 返回的结果集
 * @author Andy
 * 
 */
public class BeaconInfoResponse extends ResultState {
	private BeaconInfoResult data;

	public BeaconInfoResult getData() {
		return data;
	}

	public void setData(BeaconInfoResult data) {
		this.data = data;
	}
}
