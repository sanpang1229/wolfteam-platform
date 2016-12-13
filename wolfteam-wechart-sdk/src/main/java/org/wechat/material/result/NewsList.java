package org.wechat.material.result;

import java.util.List;

public class NewsList {
	private int total_count;
	private int item_count;
	private List<NewsItem> newsItems;

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

	public List<NewsItem> getNewsItems() {
		return newsItems;
	}

	public void setNewsItems(List<NewsItem> newsItems) {
		this.newsItems = newsItems;
	}

	@Override
	public String toString() {
		return "NewsList [item_count=" + item_count + ", newsItems="
				+ newsItems + ", total_count=" + total_count + "]";
	}
	
}