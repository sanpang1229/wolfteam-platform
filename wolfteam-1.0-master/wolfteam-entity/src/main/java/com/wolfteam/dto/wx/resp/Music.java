package com.wolfteam.dto.wx.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




/**
 *
 * @ClassName: Music
 * @Description: 音乐消息中Music类的定义 回复音乐消息
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月30日 下午4:26:20
 *
 * @version 1.0 
 *  
 */

@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "musics")
public class Music {  
    // 音乐名称  
	@XmlElement(name = "Title")
    private String title;  
    // 音乐描述 
	@XmlElement(name = "Description")
    private String description;  
    // 音乐链接 
	@XmlElement(name = "MusicUrl")
    private String musicUrl;  
    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐 
	@XmlElement(name = "HQMusicUrl")
    private String hqMusicUrl; 
	//缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	@XmlElement(name = "ThumbMediaId")
	private String thumbMediaId;
	
	
	
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
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}
	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	
    
  
}  
