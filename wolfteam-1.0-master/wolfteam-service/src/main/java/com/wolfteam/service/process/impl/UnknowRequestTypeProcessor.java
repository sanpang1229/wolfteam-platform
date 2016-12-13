package com.wolfteam.service.process.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolfteam.dto.InstructionObject;
import com.wolfteam.service.process.AbstractCompositeProcess;
import com.wolfteam.utils.wx.ResponseUtil;


@Service
@Transactional
public class UnknowRequestTypeProcessor extends AbstractCompositeProcess {
	@Override
	public void actualProcess(InstructionObject io) {
		String msg = "暂未找到答案";
		ResponseUtil.responseText(io.getResponse(), msg.toString());
	}
}
