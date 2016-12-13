package com.wolfteam.service.process;



/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月26日 下午6:34:47
 * 类说明
 * 支持
		  处理器总接口 
 *
 * @version 1.0 
 *  
 */
public interface Processor<T> {
	public void process(T t, long startTimeStamp);
}
