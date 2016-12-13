package org.wechat.sway.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.wechat.device.response.GreaterResult;

import com.alibaba.fastjson.JSONObject;

/**
 * 测试未完成
 * @author Andy
 *
 */
public class TestSwayConnection {

	@Test
	public void testData(){
		File file = new File("D:\\test.txt");
		String result = "";
		try {
			FileInputStream input = new FileInputStream(file);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] array = new byte[1024];
			int len = 0;
			try {
				while((len=input.read(array))!=-1){
					output.write(array,0,len);
				}
				result = new String(output.toByteArray());
				result = JSONObject.parseObject(result).getString("data");
				GreaterResult applyResult = JSONObject.parseObject(result,GreaterResult.class);
				System.out.println(applyResult.getErrcode());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
