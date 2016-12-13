package com.wolfteam.dto.wx.resp;


import java.util.List;

import com.wolfteam.dto.wx.model.ArticleItem;

/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年7月22日 下午5:02:17
 * 类说明
 *        文本消息
 *
 * @version 0.1 
 *  
 */
public class NewsMessageResp extends BaseMessageResp {  
    // 图文消息个数，限制为10条以内  
    private int ArticleCount;  
    // 多条图文消息信息，默认第一个item为大图  
    private List<ArticleItem> Articles;  
  
    public int getArticleCount() {  
        return ArticleCount;  
    }  
  
    public void setArticleCount(int articleCount) {  
        ArticleCount = articleCount;  
    }  
  
    public List<ArticleItem> getArticles() {  
        return Articles;  
    }  
  
    public void setArticles(List<ArticleItem> articles) {  
        Articles = articles;  
    }  
}  