package com.wolfteam.dto.wx;

import java.util.List;

public class Menu {
	
	// pid != 0  则是子菜单 
	private List<Menu> subbutton;
	
	//  菜单类型  click  或者是  view 
	private Integer menuType;
	
	// 菜单
	private String menuName;
	
	// key 类型对应的eventKey
	private String eventKey;
	
	// view  类型对应的 链接
	private String menuUrl;
	
	// 父菜单 对应的ID
	private Integer pid;
	
	// 菜单ID
	private Integer id ;
	
	// 对应的 公众号
	private String platFormUser;
	
	
	
	
	
	
}
