package org.wechat.common.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.wechat.common.entity.req.BasicMsgUserInfo;
import org.wechat.common.entity.resp.RespTextMsg;
import org.wechat.common.utils.ConvertJsonUtils;
import org.wechat.common.utils.ConvertXMLUtils;

/**
 * 测试转换xml格式数据
 * @author Andy
 *
 */
public class TestConvertXMLUtils {

	
	/**
	 * 测试将对象转换为json格式数据
	 */
	@Test
	public void testXml(){
		File file = new File("D:\\text.txt");
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
			Map<String,String> params = ConvertXMLUtils.parseXml(input);
			System.out.println(params.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将java对象转换为xml格式的字符串测试
	 */
	@Test
	public void testToXmlString(){
		RespTextMsg info = new RespTextMsg();
		info.setCreateTime(121212);
		info.setFromUserName("fromUserName");
		info.setContent("content");
		info.setToUserName("toUserName");
		String result = ConvertXMLUtils.toXMLString(info);
		System.out.println(result);
	}
	
	@Test
	public void testArrayListToJson(){
		List<String> array = new ArrayList<String>();
		array.add("111");
		String result = ConvertJsonUtils.toJsonString(array);
		System.out.println(result);
	}
}
