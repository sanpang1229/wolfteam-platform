package org.wechat.device.request;

/**
 * 设备信息
 * @author Andy
 *
 */
public class DeviceIdentifier {
	private long device_id; // 设备编号
	private String uuid; // UUID、major、minor
	private long major; //
	private long minor;

	public long getDevice_id() {
		return device_id;
	}

	public void setDevice_id(long deviceId) {
		device_id = deviceId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
}
