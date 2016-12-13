package com.wolfteam.service.process.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wechat.abbs.callutils.dispatcher.InstructionObject;
import org.wechat.abbs.callutils.dto.RequestDTO;
import org.wechat.abbs.callutils.util.ResponseUtil;

import com.wolfteam.service.process.AbstractCompositeProcess;




@Service
@Transactional
public class LocationProcessor extends AbstractCompositeProcess {
	@Override
	public void actualProcess(InstructionObject io) {
		RequestDTO request=io.getRequest();
		String msg="您的位置："+request.getLocation_X()+","+request.getLocation_Y()+"/r/n"+request.getLabel();
		ResponseUtil.responseText(io.getResponse(), msg);
	}
	
}