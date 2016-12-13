package com.wolfteam.service.process.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wechat.abbs.callutils.dispatcher.InstructionObject;
import org.wechat.abbs.callutils.util.ResponseUtil;

import com.wolfteam.service.process.AbstractCompositeProcess;



@Service
@Transactional
public class UnknowRequestTypeProcessor extends AbstractCompositeProcess {
	@Override
	public void actualProcess(InstructionObject io) {
		String msg = "暂未找到答案";
		ResponseUtil.responseText(io.getResponse(), msg.toString());
	}
}
