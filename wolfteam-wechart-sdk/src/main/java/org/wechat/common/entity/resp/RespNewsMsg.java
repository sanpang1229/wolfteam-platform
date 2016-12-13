package org.wechat.common.entity.resp;

import org.wechat.common.entity.resp.bean.Articles;

/**
 * 回复图文消息
 * 
 * @author Andy
 * 
 */
public class RespNewsMsg extends RespBasicMsg {
	private int ArticleCount; // 图文消息个数，限制为10条以内
	private Articles articles;

	@Override
	public String setMsgType() {
		return "news";
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public Articles getArticles() {
		return articles;
	}

	public void setArticles(Articles articles) {
		this.articles = articles;
	}

}
