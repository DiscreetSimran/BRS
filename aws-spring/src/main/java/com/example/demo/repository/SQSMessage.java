package com.example.demo.repository;

import java.util.List;

public class SQSMessage {
	private List<Order> Order;
	private long cid;
	
	public List<Order> getOrder() {
		return Order;
	}
	
	public Long getCid() {
		return cid;
	}
	
	public void setOrder(List<Order> Order) {
		this.Order=Order;
	}

	public void setCid(long cid) {
		this.cid=cid;
	}
}
