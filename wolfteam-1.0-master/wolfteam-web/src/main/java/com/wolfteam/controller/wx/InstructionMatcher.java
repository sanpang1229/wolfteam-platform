package com.wolfteam.controller.wx;


import com.wolfteam.dto.InstructionObject;
import com.wolfteam.dto.RequestDTO;
import com.wolfteam.dto.enumeration.RequestMsgType;
import com.wolfteam.service.process.Processor;
import com.wolfteam.service.process.impl.EventProcessor;
import com.wolfteam.service.process.impl.LocationProcessor;
import com.wolfteam.service.process.impl.PictureProcessor;
import com.wolfteam.service.process.impl.TextProcessor;
import com.wolfteam.service.process.impl.UnknowRequestTypeProcessor;
import com.wolfteam.service.process.impl.VoiceProcessor;
import com.wolfteam.util.SpringContextHolder;

/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月26日 下午6:31:24
 * 类说明
 *     指令匹配器  （ 根据微信请求的事件类型匹配对应处理器） 
 *
 * @version 1.0 
 *  
 */
public class InstructionMatcher {
	public static Processor<InstructionObject> match(InstructionObject io) {
		RequestDTO request = io.getRequest();
		System.out.println("指令匹配器===根据MsgType 进行匹配对应的处理器;MsgType>>"+request.getMsgType()+"匹配key"+RequestMsgType.getByValue(request.getMsgType()));
		switch (RequestMsgType.getByValue(request.getMsgType())) {
		case EVENT:
			return SpringContextHolder.getBean(EventProcessor.class);
		case TEXT:
			return SpringContextHolder.getBean(TextProcessor.class);
		case VOICE:
			return SpringContextHolder.getBean(VoiceProcessor.class);
		case IMAGE:
			return SpringContextHolder.getBean(PictureProcessor.class);
		case LOCATION:
			return SpringContextHolder.getBean(LocationProcessor.class);
		default:
			return SpringContextHolder.getBean(UnknowRequestTypeProcessor.class);
		}
	}

}
