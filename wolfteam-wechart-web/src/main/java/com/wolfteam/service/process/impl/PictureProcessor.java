package com.wolfteam.service.process.impl;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wechat.abbs.callutils.dispatcher.InstructionObject;
import org.wechat.abbs.callutils.dto.wx.resp.Image;
import org.wechat.abbs.callutils.util.ResponseUtil;

import com.wolfteam.service.process.AbstractCompositeProcess;



@Service
@Transactional
public class PictureProcessor extends AbstractCompositeProcess {
	@Override
	public void actualProcess(InstructionObject io) {
		System.out.println("图片事件");
		/*List<ArticleItem> items = new ArrayList<ArticleItem>();
		ArticleItem ai= new ArticleItem();
		ai.setTitle("图文表土");
		ai.setDescription("描述的内容啊啊啊啊啊 啊啊");
		ai.setPicUrl(io.getRequest().getPicUrl());
		ai.setUrl("http://www.baidu.com");
		items.add(ai);
		ResponseUtil.responseNews(io.getResponse(), items);
	*/
		
		Image i = new Image();
		String media_id =io.getRequest().getMediaId();
		if(media_id==null||media_id=="")
			media_id="Ru_6LHy5wlZDDbzacUm9mXd0JPVzzg3fqQbWLV3xtdVWZPeGwSonA-1xNoS5QaSY";
		i.setMediaId(media_id);
		ResponseUtil.responsePicInfo(io.getResponse(), i);
	}
}
