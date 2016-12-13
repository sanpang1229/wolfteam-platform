package org.wechat.device.response;

import java.util.List;

import org.wechat.common.entity.results.ResultState;
import org.wechat.device.request.DeviceIdentifier;

/**
 * 当申请设备小于于500时返回的结果
 * 
 * @author Andy
 * 
 */
public class GreaterResult extends ResultState implements java.io.Serializable {
	private int apply_id;
	private List<DeviceIdentifier> device_identifiers;

	public int getApply_id() {
		return apply_id;
	}

	public void setApply_id(int applyId) {
		apply_id = applyId;
	}

	public List<DeviceIdentifier> getDevice_identifiers() {
		return device_identifiers;
	}

	public void setDevice_identifiers(List<DeviceIdentifier> deviceIdentifiers) {
		device_identifiers = deviceIdentifiers;
	}
}
