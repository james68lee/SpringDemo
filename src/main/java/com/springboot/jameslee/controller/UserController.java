package com.springboot.jameslee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.jameslee.aop.aspect.service.UserService;
import com.springboot.jameslee.aop.aspect.validator.UserValidator;
import com.springboot.jameslee.aop.pojo.User;

//定义控制器
@Controller
//定义类请求路径
@RequestMapping("/user")
public class UserController {

	// 注入用户服务
	@Autowired
	private UserService userService = null;

	// 定义请求
	@RequestMapping("/print")
	// 返回json
	@ResponseBody
	public User printUser(Long id, String userName, String note) {
		User user = new User();
		user.setId(id);
		user.setUsername(userName);
		user.setNote(note);
		userService.printUser(user);
		return user;
	}

	// 定義URL
	@RequestMapping("/vp")
	// retrun json
	@ResponseBody
	public User validateAndPrint(Long id, String userName, String note) {
		User user = new User();
		user.setId(id);
		user.setUsername(userName);
		user.setNote(note);
		// 強制轉換
		UserValidator userValidator = (UserValidator) userService;
		// 驗證使用者是否為NULL
		if (userValidator.validate(user)) {
			userService.printUser(user);
		}
		return user;
	}

	@RequestMapping("/manyAspects")
	public String manyAspects() {
		userService.manyAspects();
		return "manyAspects";
	}

}
