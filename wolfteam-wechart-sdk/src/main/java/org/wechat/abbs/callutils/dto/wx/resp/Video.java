package org.wechat.abbs.callutils.dto.wx.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @ClassName: Video
 * @Description: 回复视频消息 对应类
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月30日 下午3:31:01
 *
 * @version 1.0 
 *  
 */

@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "video")
public class Video {
	//通过素材管理中的接口上传多媒体文件，得到的id
	@XmlElement(name = "MediaId")
	private String mediaId;
	//视频消息的标题
	@XmlElement(name = "Title")
	private String title;
	//视频消息的描述
	@XmlElement(name = "Description")
	private String description;
	
	public String getMediaId() {
		return mediaId;
	}

	
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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
	

}
