package com.sparrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.service.iface.IUserService;

/**
 * 用户控制器
 * @author       Jay
 * @time         2015年5月21日
 */
@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	IUserService helloService;
	
	@RequestMapping("hello")
	public String hello(){
		return helloService.hello();
	}
	
}
