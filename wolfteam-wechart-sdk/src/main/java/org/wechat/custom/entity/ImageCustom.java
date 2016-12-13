package org.wechat.custom.entity;

import org.wechat.common.entity.resp.bean.Image;

/**
 * 图片客服
 * @author Andy
 *
 */
public class ImageCustom extends BasicMsg{
	private Image image;

	@Override
	public String setMsgtype() {
		return "image";
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
