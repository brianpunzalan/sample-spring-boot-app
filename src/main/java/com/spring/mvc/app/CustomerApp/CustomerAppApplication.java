package com.spring.mvc.app.CustomerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CustomerAppApplication {

	public static void main(String[] args) {
            ApplicationContext ctx = SpringApplication.run(CustomerAppApplication.class, args);
            
//            System.out.println("Beans *****");
//            System.out.println(ctx.getBeanDefinitionCount());
//            
//            for (String name : ctx.getBeanDefinitionNames()) {
//                System.out.println(name);
//            }
	}

}
