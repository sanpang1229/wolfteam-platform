package org.wechat.pay.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间生成规则
 * @author Andy
 *
 */
public class FormatDateUtils {
	private static final String ORDER_FORMAT="yyyyMMddHHmmss";
	private static SimpleDateFormat format = new SimpleDateFormat(ORDER_FORMAT);
	
	/**
	 * 订单时间开始时间
	 * @return
	 */
	public static String createOrderStartTime(){
		String date = format.format(new Date());
		return date;
	}
	
	/**
	 * 生成订单结束时间
	 * @return
	 */
	public static String createOrderEndTime(){
		String date = format.format(new Date());
		return date;
	}
}
