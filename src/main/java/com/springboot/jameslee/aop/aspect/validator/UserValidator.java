package com.springboot.jameslee.aop.aspect.validator;

import com.springboot.jameslee.aop.pojo.User;

public interface UserValidator {
	
	public boolean validate(User user);
}
