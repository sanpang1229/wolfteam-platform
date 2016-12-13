package com.wolfteam.dto.wx.req;

/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年7月22日 下午4:52:27
 * 类说明
 *    请求消息之图片消息
 *
 * @version 0.1 
 *  
 */
public class ImageMessage extends BaseMessage {  
    // 图片链接  
    private String PicUrl;  
  
    public String getPicUrl() {  
        return PicUrl;  
    }  
  
    public void setPicUrl(String picUrl) {  
        PicUrl = picUrl;  
    }  
} 