package org.wechat.common.handler.impl;

import org.wechat.common.entity.resp.RespBasicMsg;
import org.wechat.common.handler.BasicXmlHandler;
import org.wechat.common.utils.XStreamFactory;

import com.thoughtworks.xstream.XStream;

/**
 * 处理类
 * @author Andy
 *
 */
public class BasicXmlHandlerImpl implements BasicXmlHandler{

	/**
	 * 
	 */
	public String toMsgXml(RespBasicMsg msg) {
		String result = "";
		if(msg!=null){
			XStream xs = XStreamFactory.init(true);
			xs.alias("xml",msg.getClass());
			result = xs.toXML(msg);
		}
		return result;
	}
}
