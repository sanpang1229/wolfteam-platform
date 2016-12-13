package com.wolfteam.controller.wx;


import org.wechat.abbs.callutils.dispatcher.InstructionObject;
import org.wechat.abbs.callutils.dto.RequestDTO;
import org.wechat.abbs.callutils.thread.Processor;
import org.wechat.abbs.callutils.enumeration.RequestMsgType;

import com.wolfteam.service.process.impl.EventProcessor;
import com.wolfteam.service.process.impl.LocationProcessor;
import com.wolfteam.service.process.impl.PictureProcessor;
import com.wolfteam.service.process.impl.TextProcessor;
import com.wolfteam.service.process.impl.UnknowRequestTypeProcessor;
import com.wolfteam.service.process.impl.VoiceProcessor;
import com.wolfteam.wx.util.SpringContextHolder;




/**
 *
 * @ClassName: InstructionMatcher
 * @Description:  指令匹配器  （ 根据微信请求的事件类型匹配对应处理器） 
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年11月28日   下午8:00:41
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
		        System.out.println(request.getMsgType()+"--未匹配到对应的事件处理陪类型！");
			return SpringContextHolder.getBean(UnknowRequestTypeProcessor.class);
		}
	}

}
