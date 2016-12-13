package com.wolfteam.dao.wx;

import com.wolfteam.po.SubscribeUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 
 * SubscribeUserMapper数据库操作接口类
 * 
 **/

public interface SubscribeUserMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	SubscribeUser  selectByPrimaryKey ( @Param("id") Integer id );

	/**
	 * 
	 * 查询（根据条件查询）
	 * 
	 **/
	List<SubscribeUser>  selectByWhere ( SubscribeUser	 record );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	Integer deleteByPrimaryKey ( @Param("id") Integer id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	Integer insert( SubscribeUser record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	Integer insertSelective( SubscribeUser record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	Integer updateByPrimaryKeySelective( SubscribeUser record );

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	Integer updateByPrimaryKey ( SubscribeUser record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 插入非重复的数据(高并发)
	 * 
	 **/
	Integer insertSelectiveUnique(SubscribeUser user);
	
	/**
	 * 
	 * 根据 openId 查询是否关注
	 * 插入非重复的数据(高并发)
	 * 
	 **/
	SubscribeUser queryIsSubscribed(@Param("openid")String openid);

	void cancelSubscribEvent(@Param("openid")String openid);

}