package com.example.Service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;



@Service("service")
public class PurchaseOrderImpl implements IPurchaseOrder {
     @Autowired
	private JavaMailSender sender;
     @Value("${spring.mail.username}")
     private String fromEmail;
	@Override
	public String purchase(String[] items, double[] prices, String[] emails) throws Exception {
		double bill=0.0;
		for(double price:prices) 
			bill=bill+price;
			String msg=Arrays.toString(items)+"with prices "+Arrays.toString(prices)+" are purchaged with bill amount"+bill;
		
			String status=sendMail(msg,emails);
			return msg+"=======>"+status;
	}
	private String sendMail(String msg,String[] emails) throws Exception {
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setFrom(fromEmail);
		helper.setCc(emails);
		helper.setSubject("open it to know it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("sai.png.jpeg",new ClassPathResource("sai.png.jpeg"));
		sender.send(message);
		return "mail send";
		
		
	}

}
