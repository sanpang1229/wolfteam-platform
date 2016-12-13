package org.wechat.material.result;

import java.util.List;

/**
 * 获取消息集合的Item
 * 
 * @author Andy
 * 
 */
public class OtherList {
	private int total_count;
	private int item_count;
	private List<OtherItem> list; // 素材的数量

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int totalCount) {
		total_count = totalCount;
	}

	public int getItem_count() {
		return item_count;
	}

	public void setItem_count(int itemCount) {
		item_count = itemCount;
	}

	public List<OtherItem> getList() {
		return list;
	}

	public void setList(List<OtherItem> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "OtherList [item_count=" + item_count + ", list=" + list
				+ ", total_count=" + total_count + "]";
	}
}
