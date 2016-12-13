package com.wolfteam.service.wx.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wechat.abbs.callutils.util.AccessTokenMap;
import org.wechat.abbs.callutils.util.WXPlatAPIUtil;

import com.wolfteam.dao.wx.SubscribeUserMapper;
import com.wolfteam.pojo.wx.SubscribeUser;
import com.wolfteam.service.wx.IWxSubscribeUserService;

import net.sf.json.JSONObject;

@Service
public class WxSubscribeUserService implements IWxSubscribeUserService {
	private static Log log = LogFactory.getLog(WxSubscribeUserService.class);
	@Autowired
	private SubscribeUserMapper subscribeUserMapper;
	
	// 处理用户关注操作
	public void ProcessWxSubScribeBussniess(String openid, String platform) throws Exception{
		// 判断用户是否之前关注过  根据openid
		SubscribeUser sub =subscribeUserMapper.queryIsSubscribed(openid);
		if(sub==null){
			// 新增用户  根据accessToken openId 获取用户信息
			bindSubScribeUserInofByFromUserName(openid,platform);
		}else{
			// 老用户重新关注 如果用户关注的时间 在二个月内 不更新用户信息 否则更新信息
			System.out.println(sub.getSubscribeTime());
			System.out.println(sub.toString());
			 if(sub.getSubscribeTime().before(backDateInfo(new Date(),-2))){
				 sub=callSubscribeUserInfoByHttpRequest(openid,platform);
			 }else{
				 sub.setSubscribe("1");
				 sub.setUpdateTime(new Date());
				 sub.setDeleteFlag(0);
			 }
			subscribeUserMapper.updateByPrimaryKeySelective(sub);
		}
		
	}
	private Date backDateInfo(Date start,int mouth){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");//格式化对象
		  Calendar calendar = Calendar.getInstance();//日历对象
		  calendar.setTime(start);//设置当前日期
		  calendar.add(Calendar.MONTH, mouth);//于芬操作
		  System.out.println(sdf.format(calendar.getTime()));//输出格式化的日期
		return calendar.getTime();
	}
	
	// 根据微信接口获取用户信息
	private  SubscribeUser callSubscribeUserInfoByHttpRequest(String openid, String platform) throws Exception{
		String accesToken = AccessTokenMap.getAccessToekn("AccessToken", new Date());
		log.error("   accesToken"+accesToken);
		JSONObject userJson = WXPlatAPIUtil.getSubscribeUser(accesToken,openid );
		log.error("   userJson了"+userJson);
		 SubscribeUser user = new SubscribeUser(
				 	null, 
				 	userJson.getString("openid"), 
				 	userJson.getString("subscribe"),
				 	userJson.getString("nickname"), 
				 	(Integer)userJson.getInt("sex"),
				 	userJson.getString("city"),
				 	userJson.getString("country"),
				 	userJson.getString("province"),
				 	userJson.getString("language"),
				 	userJson.getString("headimgurl"),
				 	null,
				 	null, 
				 	userJson.getString("remark"),
				 	userJson.getString("groupid"),
				 	userJson.getJSONArray("tagid_list").toString(),
				 	platform,
				 	null,
				 	null,
				 	0);
		
		
		return user;
		
	}
	
	//  绑定用户
	public void bindSubScribeUserInofByFromUserName(String subscribeUser, String platform) throws Exception {
		SubscribeUser sub = callSubscribeUserInfoByHttpRequest(subscribeUser,platform);
		 subscribeUserMapper.insertSelectiveUnique(sub);
		
	}
	// 取消关注
	public void ProcessUnSubScribeBussniess(String openid) {
		subscribeUserMapper.cancelSubscribEvent(openid);
		
	}

}
