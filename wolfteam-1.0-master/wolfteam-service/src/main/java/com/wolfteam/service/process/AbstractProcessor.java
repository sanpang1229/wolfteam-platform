package com.wolfteam.service.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolfteam.dao.wx.IAutoReplyConfigDao;
import com.wolfteam.dto.InstructionObject;
import com.wolfteam.dto.wx.model.ArticleItem;
import com.wolfteam.util.Exceptions;

@Service
@Transactional
public abstract class AbstractProcessor implements Processor<InstructionObject>{

	Logger log = LoggerFactory.getLogger(getClass());
	
	
	public final void beforeProcess(InstructionObject io) {
	}
	
	/**
	 * 回复内容，后续用到
	 * @param io
	 */
	public void reply(InstructionObject io){
		
	}
	
	public String replaceChar(String str,InstructionObject io){
		return str;
	}
	
	
	
	public abstract void actualProcess(InstructionObject io);
	
	/**
	 * 获取异常信息
	 * @return
	 */
	public String getExceptionMessage() {
		return "对不起，系统正忙，请稍后再试。";
	};
	
	public String getUnknowMessage() {
		return "对不起，您的输入有误！";
	}
	
	public final void process(InstructionObject io, long startTimeStamp) {
		beforeProcess(io);
		try {
				actualProcess(io);
		} catch (Exception e) {
			log.error(io.getRequest().getPlatformUserName() + ","
					+ io.getRequest().getContent()
					+ " process exception caused by:\n"
					+ Exceptions.getStackTraceAsString(e));
		}
	}
}

