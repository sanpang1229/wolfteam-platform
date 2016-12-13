package com.wolfteam.conmon;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年7月22日 下午5:07:14
 * 类说明
 *    那么如何解析请求消息的问题也就转化为如何从request中得到微信服务器发送给我们的xml格式的消息了。
 *    这里我们借助于开源框架dom4j去解析xml（这里使用的是dom4j-1.6.1.jar），然后将解析得到的结果存入HashMap，解析请求消息的方法如下：
 *
 * @version 0.1 
 *  
 */
public class WxRequestMessagesPareUtils {
	/** 
	 * 如何解析请求消息?
	 * 
	 * 解析微信发来的请求（XML） 
	 *  
	 * @param request 
	 * @return 
	 * @throws Exception 
	 */  
	@SuppressWarnings("unchecked")  
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
	    // 将解析结果存储在HashMap中  
	    Map<String, String> map = new HashMap<String, String>();  
	  
	    // 从request中取得输入流  
	    InputStream inputStream = request.getInputStream();  
	    // 读取输入流  
	    SAXReader reader = new SAXReader();  
	    Document document = reader.read(inputStream);  
	    // 得到xml根元素  
	    Element root = document.getRootElement();  
	    // 得到根元素的所有子节点  
	    List<Element> elementList = root.elements();  
	  
	    // 遍历所有子节点  
	    for (Element e : elementList)  
	        map.put(e.getName(), e.getText());  
	  
	    // 释放资源  
	    inputStream.close();  
	    inputStream = null;  
	  
	    return map;  
	} 

}
