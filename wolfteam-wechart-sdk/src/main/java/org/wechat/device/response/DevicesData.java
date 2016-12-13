package org.wechat.device.response;

import java.util.List;

/**
 * 设备数据
 * 
 * @author Andy
 * 
 */
public class DevicesData {

	private List<DeviceItem> devices; // 设备信息
	private int total_count; // 商户名下的设备总量

	public List<DeviceItem> getDevices() {
		return devices;
	}

	public void setDevices(List<DeviceItem> devices) {
		this.devices = devices;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int totalCount) {
		total_count = totalCount;
	}
}
