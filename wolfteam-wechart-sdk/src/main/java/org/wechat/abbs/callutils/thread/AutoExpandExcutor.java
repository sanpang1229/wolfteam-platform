package org.wechat.abbs.callutils.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @ClassName: AutoExpandExcutor
 * @Description: 自动扩展线程池执行器
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月29日 下午4:47:04
 *
 * @version 1.0 
 *  
 */

public class AutoExpandExcutor {

	private static ExecutorService executor = Executors.newFixedThreadPool(50);
	
	public static void execute(Runnable task) {
		executor.execute(task);
	}
}