package org.wechat.device.response;

/**
 * 摇一摇获取摇周边的设备及用户信息
 * 
 * @author Andy
 * 
 */
public class BeaconInfo {
	private double distance; // Beacon信号与手机的距离，单位为米
	private long major; //
	private long minor; //
	private String uuid; //

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public long getMajor() {
		return major;
	}

	public void setMajor(long major) {
		this.major = major;
	}

	public long getMinor() {
		return minor;
	}

	public void setMinor(long minor) {
		this.minor = minor;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
