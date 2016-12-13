package com.wolfteam.service.process.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wechat.abbs.callutils.dispatcher.InstructionObject;
import org.wechat.abbs.callutils.util.ResponseUtil;

import com.wolfteam.service.process.AbstractCompositeProcess;



/**
 *
 * @ClassName: TextProcessor
 * @Description: 文本消息处理
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月29日 下午5:10:09
 *
 * @version 1.0 
 *  
 */
@Service
@Transactional(readOnly = false)
public class TextProcessor extends AbstractCompositeProcess {

	@Override
	public void actualProcess(InstructionObject io) {
		String msg = "文本消息回复";
		ResponseUtil.responseText(io.getResponse(), io.getRequest().getContent());
		
	}
}


