package com.wolfteam.dao.wx;

import java.util.List;
import java.util.Map;

import com.wolfteam.pojo.wx.AutoReplyConfigDTO;
import com.wolfteam.pojo.wx.PersonInfo;



public interface IAutoReplyConfigDao {
	/**
	 * 根据关键字查询回复内容列表
	 * @param map
	 * @return
	 */
	public List eventReply(Map map);
	/**
	 * 
	* @Title: addrBookReply
	* @Description: 根据输入的姓名查询通讯录
	* @param @param map
	* @param @return    
	* @return List<PersonInfo>
	 */
	public List<PersonInfo> addrBookReply(Map map);
	/**
	 * 
	* @Title: getReplyInfoByOrginId
	* @Description: 自动回复
	* @param @param orginId
	* @param @return    
	* @return List<AutoReplyConfigDTO>
	 */
	public List<AutoReplyConfigDTO> getReplyInfoByOrginId(String orginId);
	/**
	 * 
	* @Title: addMenuReply
	* @Description: 添加菜单默认回复
	* @param @param param    
	* @return void
	 */
	public void addMenuReply(Map<String, Object> param);
}
