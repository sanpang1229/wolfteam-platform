package com.wolfteam.service.process.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolfteam.dto.InstructionObject;
import com.wolfteam.dto.RequestDTO;
import com.wolfteam.service.process.AbstractCompositeProcess;
import com.wolfteam.service.wx.IWxSubscribeUserService;
import com.wolfteam.utils.wx.ResponseUtil;
import com.wolfteam.dto.enumeration.EventType;
import com.wolfteam.dto.enumeration.RequestMsgType;
import com.wolfteam.dto.wx.model.ArticleItem;;


/**
 *
 * @ClassName: EventProcessor
 * @Description: 事件处理
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月29日 下午3:02:42
 * 
 * @version 1.0 
 *  
 */

@Service
@Transactional(readOnly = false)
public class EventProcessor extends AbstractCompositeProcess {
	
	private static Log log = LogFactory.getLog(EventProcessor.class);
	@Autowired
	private IWxSubscribeUserService   wxSubscribeUserService;

	@Override
	public void actualProcess(InstructionObject io) {
		// LOCATION(1, "event", "上报地理位置事件"),
		// CLICK(2, "event", "点击菜单拉取消息的事件推送"),
		// VIEW(3, "event", "点击菜单跳转链接的事件推送"),
		// scancode_push(4, "event", "扫码推事件的事件推送"),
		// scancode_waitmsg(5, "event", "扫码推事件且弹出“消息接收中”提示框的事件推送"),
		// pic_sysphoto(6, "event", "弹出系统拍照发图的事件推送"),
		// pic_photo_or_album(7, "event", "弹出拍照或者相册发图的事件推送"),
		// pic_weixin(8, "event", "弹出微信相册发图器的事件推送"),
		// location_select(9, "event", "弹出地理位置选择器的事件推送"),
		// subscribe(10, "event", "订阅"),
		// unsubscribe(11, "event", "取消订阅");
		
		System.out.println("EventProcess 事件处理器;EventType的Value>>"+io.getRequest().getEvent()+"匹配事件类型对应类型EventType>>"+EventType.getByValue(io.getRequest().getEvent()));
		switch (EventType.getByValue(io.getRequest().getEvent())) {
		case subscribe:
			log.error("============关注事件==人"+"："+io.getRequest().getFromUserName());
			event_Subscribe(io);
			break;
		case LOCATION:
			event_Location(io);
			break;
		case unsubscribe:
			event_UnSubscribe(io);
			System.out.println("unsubscribe"+io.getRequest().getFromUserName());
			break;
		case click:
			event_Click(io);
			break;
		case view:
			System.out.println("view"+io.getRequest().getFromUserName());
			break;
		case scancode_push:
			break;
		case scancode_waitmsg:
			break;
		case pic_sysphoto:
			break;
		case pic_photo_or_album:
			break;
		case pic_weixin:
			break;
		case location_select:
			break;
		default:
			break;
		}
	}

	private void event_UnSubscribe(InstructionObject io) {
		// 取消关注事件   
		wxSubscribeUserService.ProcessUnSubScribeBussniess(io.getRequest().getFromUserName());
	}

	/**
	 * 点击菜单  根据对应的EventKey匹配对应的处理
	 */
	private void event_Click(InstructionObject io) {
			System.out.println("点击菜单事件");
			ResponseUtil.responseText(io.getResponse(), "点击菜单事件的EventKey"+io.getRequest().getEventKey());
		}

	/**
	 * 上报地理位置
	 */
	private void event_Location(InstructionObject io) {
		System.out.println("上班地理位置事件");
		ResponseUtil.responseText(io.getResponse(), "上班地理位置事件");
		
		}

	/**
	 * 关注事件
	 */
	private void event_Subscribe(InstructionObject io) {
		log.info("关注事件");
		try {
			wxSubscribeUserService.ProcessWxSubScribeBussniess(io.getRequest().getFromUserName(),io.getRequest().getPlatformUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//  将用户信息保存到数据库 标识未完善状态
		List<ArticleItem> items = new ArrayList<ArticleItem>();
		ArticleItem ai= new ArticleItem();
		ai.setTitle("微信公众平台欢迎您的到来！");
		ai.setDescription("在这里你会发现一个不一样的平台,直接搜索你想要的信息,观看最热门的资讯信息！");
		ai.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/5nWibTtmg9k3hqBPHeozWAbnqpQLoMmPd0uoAVbmaIdoXSXLqK5KuDjLWQXy9RdAV7IqTficQqFWPSauuyllqIHw/0");
		ai.setUrl("http://www.baidu.com");
		items.add(ai);
		ResponseUtil.responseNews(io.getResponse(), items);
		
	}
	
	
	/**
	 * 体验号关注事件
	 * @param io
	 */
	private void event_tyh_Subscribe(InstructionObject io) {}

}