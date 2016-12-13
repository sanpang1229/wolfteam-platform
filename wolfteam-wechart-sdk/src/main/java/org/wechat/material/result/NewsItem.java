package org.wechat.material.result;

import java.util.List;

import org.wechat.msg.entity.NewsEntity;

/**
 * 图文List 中的选项 item
 * @author Andy
 *
 */
public class NewsItem {
	private String media_id;		//media编号
	private List<NewsEntity> newsItem;	//图文消息的list集合
	private String update_time;		//更新的时间
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String mediaId) {
		media_id = mediaId;
	}
	public List<NewsEntity> getNewsItem() {
		return newsItem;
	}
	public void setNewsItem(List<NewsEntity> newsItem) {
		this.newsItem = newsItem;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String updateTime) {
		update_time = updateTime;
	}
}
