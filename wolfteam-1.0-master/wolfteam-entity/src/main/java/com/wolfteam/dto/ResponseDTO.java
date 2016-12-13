package com.wolfteam.dto;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.wolfteam.dto.wx.model.ArticleItem;
import com.wolfteam.dto.wx.resp.Image;
import com.wolfteam.dto.wx.resp.Music;
import com.wolfteam.dto.wx.resp.Video;
import com.wolfteam.dto.wx.resp.Voice;


@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ResponseDTO {
	//接收方帐号（收到的OpenID）
	@XmlElement(name = "ToUserName")
	private String toUserName;
	//开发者微信号
	@XmlElement(name = "FromUserName")
	private String platformUserName;
	//	消息创建时间 （整型）
	@XmlElement(name = "CreateTime")
	private long createTime;
	// 返回的消息类型
	@XmlElement(name = "MsgType")
	private String msgType;
	//
	@XmlElement(name = "Content",required=false)
	private String content;
	
	@XmlElement(name = "FuncFlag",required=false)
	private Integer funcFlag;
	
	@XmlElement(name = "ArticleCount",required=false)
	private Integer articleCount;
	
	@XmlElementWrapper(name="Articles")@XmlElements(@XmlElement(name="item",required=false))
	private List<ArticleItem> items;
	
	//	 返回单独的图片信息
	@XmlElement(name = "Image",required=false)
	private Image image;
	
	//	 返回单独的语言信息
	@XmlElement(name = "Voice",required=false)
	private Voice voice;
	
	//	 返回视频消息信
	@XmlElement(name = "Video",required=false)
	private Video video;
	
	//	 返回视频消息信
	@XmlElement(name = "Music",required=false)
	private Music music;
	
	private Integer id;
	
	public ResponseDTO(){
		
	}
	
	public ResponseDTO(String toUserName,String platformUserName,long createTime){
		this.toUserName=toUserName;
		this.platformUserName=platformUserName;
		this.createTime=createTime;
	}
	
	public ResponseDTO(RequestDTO request){
		this(request.getFromUserName(), request.getPlatformUserName(), request.getCreateTime());
	}
	
	
	
	
	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getPlatformUserName() {
		return platformUserName;
	}
	public void setPlatformUserName(String platformUserName) {
		this.platformUserName = platformUserName;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getFuncFlag() {
		return funcFlag;
	}
	public void setFuncFlag(Integer funcFlag) {
		this.funcFlag = funcFlag;
	}
	public Integer getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
	public List<ArticleItem> getItems() {
		return items;
	}
	public void setItems(List<ArticleItem> items) {
		this.items = items;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
