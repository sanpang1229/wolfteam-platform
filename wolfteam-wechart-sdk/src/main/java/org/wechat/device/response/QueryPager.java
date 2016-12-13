package org.wechat.device.response;

import java.util.List;

import org.wechat.device.request.EditPagerRequest;

/**
 * 查询页面返回值
 * 
 * @author Andy
 * 
 */
public class QueryPager {

	private List<EditPagerRequest> pages;
	private int total_count;

	public List<EditPagerRequest> getPages() {
		return pages;
	}

	public void setPages(List<EditPagerRequest> pages) {
		this.pages = pages;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int totalCount) {
		total_count = totalCount;
	}
}
