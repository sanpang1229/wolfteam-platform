package org.wechat.common.handler;

import java.util.Map;

import org.wechat.common.entity.req.BasicMsgUserInfo;
import org.wechat.common.entity.resp.RespBasicMsg;


/**
 * 请求消息处理
 * @author Andy
 *
 */
public interface ReqMsgHandler {
	
	/**
	 * 用户发送的为文本消
	 * @param msg		基础消息
	 * @param params	请求参数 
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	public RespBasicMsg textMsg(BasicMsgUserInfo msg,Map<String,String> params);
	
	
	/**
	 * 连接消息
	 * @param msg
	 * @param params
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	public RespBasicMsg linkMsg(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 默认执行的消息
	 * @param msg
	 * @param params
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	public RespBasicMsg defaultMsg(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 音乐执行的消息
	 * @param msg	基础参数
	 * @param params	请求参数
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	public RespBasicMsg musicMsg(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 图片消息
	 * @param msg
	 * @param params
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	public RespBasicMsg imageMsg(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 地理位置消息
	 * @param msg
	 * @param params
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	public RespBasicMsg locationMsg(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 语言消息
	 * @param msg
	 * @param params
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	public RespBasicMsg voiceMsg(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 视频消息
	 * @param msg 消息基类
	 * @param params
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	public RespBasicMsg videoMsg(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 小视频消息
	 * @param msg
	 * @param params
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	public RespBasicMsg shortvideo(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 消息类型为空时的默认回复,(该方法可不实现 情况基本没有)
	 * @param msg
	 * @param params
	 * @return
	 */
	public RespBasicMsg msgTypeIsNullDefaultReply(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 事件类型为空时的默认回复 	(MsgType为event Event==null的情况)
	 * (该方法可不实现,)
	 * @param msg
	 * @param params
	 * @return
	 */
	public RespBasicMsg eventTypeIsNullDefaultReply(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 用户关注时调用的方法
	 * @param msg
	 * @param params
	 * @return
	 */
	public RespBasicMsg subscribe(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 取消关注时调用的方法
	 * @param msg
	 * @param params
	 * @return
	 */
	public RespBasicMsg unsubscribe(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 用户已关注时的事件推送
	 * @param msg	
	 * @param params
	 * @return
	 */
	public RespBasicMsg scan(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 上报地理位置事件
	 * @param msg
	 * @param params
	 * @return
	 */
	public RespBasicMsg eventLocation(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 点击菜单拉取消息时的事件推送 (自定义菜单的click在这里做响应)
	 * @param msg  
	 * @param params
	 * @return
	 */
	public RespBasicMsg eventClick(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 点击菜单跳转链接时的事件推送 (自定义菜单的view在这里做响应)
	 * @param msg
	 * @param params
	 * @return
	 */
	public RespBasicMsg eventView(BasicMsgUserInfo msg,Map<String,String> params);
	
	/**
	 * 事件类型默认返回
	 * @param msg
	 * @param params
	 * @return
	 */
	public RespBasicMsg eventDefaultReply(BasicMsgUserInfo msg,Map<String,String> params);
	
	
}
