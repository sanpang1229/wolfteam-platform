package com.wolfteam.service.process.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolfteam.dto.InstructionObject;
import com.wolfteam.dto.wx.resp.Voice;
import com.wolfteam.service.process.AbstractCompositeProcess;
import com.wolfteam.utils.wx.ResponseUtil;

/**
 *
 * @ClassName: VoiceProcessor
 * @Description: 	语言处理器
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月30日 下午2:17:17
 *
 * @version 1.0 
 *  
 */

@Service
@Transactional
public class VoiceProcessor extends AbstractCompositeProcess {
	@Override
	public void actualProcess(InstructionObject io) {
		Voice v = new Voice();
		v.setMediaId(io.getRequest().getMediaId());
		ResponseUtil.responseVoicefo(io.getResponse(), v);
	}

}
