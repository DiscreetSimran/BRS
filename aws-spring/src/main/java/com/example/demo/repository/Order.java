package com.example.demo.repository;

import java.util.List;

public class Order {
	
	private String Order_id;
	private List<Type> type;
	
	public String getOrder_id() {
		return Order_id;
	}
	
	public List<Type> getType(){
		return type;
	}
	
	public void setOrder_id(String Order_id) {
		this.Order_id=Order_id;
	}
	
	public void setType(List<Type> type) {
		this.type=type;
		
	}

}
