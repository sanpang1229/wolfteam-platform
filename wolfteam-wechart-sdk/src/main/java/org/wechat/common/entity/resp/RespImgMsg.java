package org.wechat.common.entity.resp;

import org.wechat.common.entity.resp.bean.Image;

/**
 * 回复图片消息
 * 
 * @author Andy
 * 
 */
public class RespImgMsg extends RespBasicMsg {
	private Image image;

	@Override
	public String setMsgType() {
		return "image";
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
