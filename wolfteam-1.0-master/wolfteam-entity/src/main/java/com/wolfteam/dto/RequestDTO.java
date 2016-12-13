package com.wolfteam.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @ClassName: RequestDTO
 * @Description: 接受微信公众号请求的消息 是XML 格式  (包含了所以的请求消息类型)
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月29日 下午4:19:44
 *
 * @version 1.0 
 *  
 */

@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class RequestDTO {
	/**所有请求的基本信息*/ 
	
	// 开发者(公众号平台)微信号 
	@XmlElement(name = "ToUserName")
	private String platformUserName;
	//  发送方帐号（用户一个OpenID） 
	@XmlElement(name = "FromUserName")
	private String fromUserName;
	// 消息创建时间 （整型）  
	@XmlElement(name = "CreateTime")
	private long createTime;
	// 消息类型（text/music/news）
	@XmlElement(name = "MsgType")
	private String msgType;
	// 消息id，64位整型
	@XmlElement(name = "MsgId", required = false)
	private Long msgId;
	// 事件推送
	@XmlElement(name = "Event", required = false)
	private String event;
	@XmlElement(name = "EventKey", required = false)
	private String eventKey;
	
	/** 请求消息之文本消息  */ 
	// 文本内容
	@XmlElement(name = "Content", required = false)
	private String content;
	
	/** 请求消息之图片消息 */
	// 图片消息
	@XmlElement(name = "PicUrl", required = false)
	private String picUrl;
	
	/** 请求消息之链接消息 */
	// 链接消息
	@XmlElement(name = "Title", required = false)
	private String title;
	@XmlElement(name = "Description", required = false)
	private String description;
	@XmlElement(name = "Url", required = false)
	private String url;
	
	/** 请求消息之地理位置消息*/
	// 地理位置
	@XmlElement(name = "Location_X", required = false)
	private Float location_X;
	@XmlElement(name = "Location_Y", required = false)
	private Float location_Y;
	@XmlElement(name = "Scale", required = false)
	private Integer scale;
	@XmlElement(name = "Label", required = false)
	private String label;
	
	/** 请求消息之语音消息*/
	
	// 语音消息
	 // 媒体ID  
	@XmlElement(name = "MediaId", required = false)
	private String mediaId;
	// 语音格式
	@XmlElement(name = "Format", required = false)
	private String format;
	/** 暂时不用 */
	//上报地理位置
	@XmlElement(name = "Longitude", required = false)
	private Float Longitude;
	@XmlElement(name = "Latitude", required = false)
	private Float Latitude;
	@XmlElement(name = "Precision", required = false)
	private Float Precision;
	
	
	
	
	
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getPlatformUserName() {
		return platformUserName;
	}
	public void setPlatformUserName(String platformUserName) {
		this.platformUserName = platformUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
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
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Float getLocation_X() {
		return location_X;
	}
	public void setLocation_X(Float location_X) {
		this.location_X = location_X;
	}
	public Float getLocation_Y() {
		return location_Y;
	}
	public void setLocation_Y(Float location_Y) {
		this.location_Y = location_Y;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Float getLongitude() {
		return Longitude;
	}
	public void setLongitude(Float longitude) {
		Longitude = longitude;
	}
	public Float getLatitude() {
		return Latitude;
	}
	public void setLatitude(Float latitude) {
		Latitude = latitude;
	}
	public Float getPrecision() {
		return Precision;
	}
	public void setPrecision(Float precision) {
		Precision = precision;
	}
	 
	

}
