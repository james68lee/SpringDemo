package com.springboot.jameslee.aop.aspect.service;

import com.springboot.jameslee.aop.pojo.User;

public interface UserService {
	
	public void printUser();

	public void printUser(User user);
	
	
	public void manyAspects();
}
