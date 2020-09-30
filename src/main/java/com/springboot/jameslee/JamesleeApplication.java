package com.springboot.jameslee;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JamesleeApplication {
	@PostConstruct
    public void start() throws Exception {
		System.out.println("@SpringBootApplication @PostConstruct");
    }

    @PreDestroy
    public static void tearDown() {
       System.out.println("@SpringBootApplication @PreDestroy");
    }

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
            	System.out.println("@SpringBootApplication addShutdownHook run");
                tearDown();
            }   
        });
		SpringApplication.run(JamesleeApplication.class, args);
	}

}
