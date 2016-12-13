package com.wolfteam.service.process.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolfteam.dto.InstructionObject;
import com.wolfteam.dto.RequestDTO;
import com.wolfteam.service.process.AbstractCompositeProcess;
import com.wolfteam.utils.wx.ResponseUtil;



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