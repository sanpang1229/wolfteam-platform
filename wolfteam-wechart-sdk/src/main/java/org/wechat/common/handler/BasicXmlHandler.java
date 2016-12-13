package org.wechat.common.handler;


import org.wechat.common.entity.resp.RespBasicMsg;

/**
 * xml 处理类
 * @author Andy
 */
public interface BasicXmlHandler{
	
	/**
	 * 将java对象转换为xml
	 * @param <T>
	 * @param t 待转换的对象
	 * @return  已经转换好的xml格式字符
	 */
	public String toMsgXml(RespBasicMsg msg);
}
