package org.wechat.device.response;

import java.util.List;

import org.wechat.common.entity.results.ResultState;

/**
 * 摇一摇统计返回的结果
 * @author Andy
 *
 */
public class CountDataResponse extends ResultState {

	private List<CountData> data;

	public List<CountData> getData() {
		return data;
	}

	public void setData(List<CountData> data) {
		this.data = data;
	}

}
