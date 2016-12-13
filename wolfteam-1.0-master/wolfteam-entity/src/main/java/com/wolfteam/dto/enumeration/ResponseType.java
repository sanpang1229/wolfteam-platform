package com.wolfteam.dto.enumeration;


/**
 *
 * @ClassName: ResponseType
 * @Description: 回复文档
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月29日 下午5:19:27
 *
 * @version 1.0 
 *  
 */

public enum ResponseType {
	TEXT(0, "文本消息"),
	NEWS(1, "图文消息"),
	MUSIC(2, "音乐消息"),
	IMAGE(3, "图片消息"),
	VOICE(4, "语言消息"),
	VIDEO(5, "视频消息");
	
	private Integer value;
	private String desc;
	
	private ResponseType(Integer value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
}