package com.wolfteam.controller.wx;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/v")
@Controller
public class VistController {
	private static Logger logger = Logger.getLogger(VistController.class);
	
	// 跳转到登录页面 
	@RequestMapping("/aa")
	@ResponseBody
	public String login(HttpServletRequest request) 
	{
			System.out.println("1233");
		return "login";
	} 
		

}