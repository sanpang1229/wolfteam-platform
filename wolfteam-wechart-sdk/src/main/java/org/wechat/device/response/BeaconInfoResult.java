package org.wechat.device.response;

/**
 * 获取摇周边的设备及用户信息
 * 
 * @author Andy
 * 
 */
public class BeaconInfoResult {

	private long page_id; // 摇周边页面唯一ID
	private String openid; // openId
	private BeaconInfo beacon_info; // 设备信息，包括UUID、major、minor，以及距离

	public long getPage_id() {
		return page_id;
	}

	public void setPage_id(long pageId) {
		page_id = pageId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public BeaconInfo getBeacon_info() {
		return beacon_info;
	}

	public void setBeacon_info(BeaconInfo beaconInfo) {
		beacon_info = beaconInfo;
	}
}
