package com.springboot.jameslee.aop.aspect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.springboot.jameslee.aop.aspect.JamesLeeAspect;
import com.springboot.jameslee.aop.aspect.service.impl.UserServiceImpl;

@Configuration  
//启动@AspectJ切面编程  
@EnableAspectJAutoProxy  
//定义扫描包  
@ComponentScan(basePackages = {"com.springboot.jameslee.aop.aspect.*"}, basePackageClasses = UserServiceImpl.class)
public class AspectConfig {
	
	@Bean(name = "jamesLeeAspect")
	public JamesLeeAspect initMyAspect() {
	    return new JamesLeeAspect();
	}
}
