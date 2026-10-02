package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import com.example.Service.PurchaseOrderImpl;

@SpringBootApplication
public class SpringBootEmailSenderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootEmailSenderApplication.class, args);
	    PurchaseOrderImpl order=run.getBean("service",PurchaseOrderImpl.class);
	    try {
	    	String msg=order.purchase(new String[]{"shirt", "dress","scarf"}, new double[]{500.0,1500.0,2000.0},new String[] {"krishnasai6302626@gmail.com","nsivakrishna97@gmail.com"});
	    	System.out.println(msg);
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	
	
	
	
	
	
	}

}
