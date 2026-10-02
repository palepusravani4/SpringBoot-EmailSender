package com.example.Service;

public interface IPurchaseOrder {
	
	public String purchase(String []items,double []prices,String []emails)throws Exception;

}
