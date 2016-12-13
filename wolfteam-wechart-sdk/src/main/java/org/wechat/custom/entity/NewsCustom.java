package org.wechat.custom.entity;

/**
 * 图文客服消息
 * 
 * @author Andy
 * 
 */
public class NewsCustom extends BasicMsg {
	private News news;

	@Override
	public String setMsgtype() {
		return "news";
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}
