package org.wechat.abbs.callutils.dto.wx.req;


/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年7月22日 下午4:51:21
 * 类说明
 * 
 *  请求消息之文本消息
 *
 * @version 0.1 
 *  
 */
public class TextMessage extends BaseMessage {  
  // 消息内容  
  private String Content;  

  public String getContent() {  
      return Content;  
  }  

  public void setContent(String content) {  
      Content = content;  
  }  
}  
