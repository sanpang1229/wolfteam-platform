package org.wechat.device.response;

import org.wechat.common.entity.results.ResultState;

/**
 * 查询页面返回的结果
 * @author Andy
 */
public class QueryResponse extends ResultState {
	private QueryPager data;

	public QueryPager getData() {
		return data;
	}

	public void setData(QueryPager data) {
		this.data = data;
	}
}
