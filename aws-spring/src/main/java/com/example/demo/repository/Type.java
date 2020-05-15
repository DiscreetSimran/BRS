package com.example.demo.repository;



public class Type {
	
	private String type_name;
	private String ASIN;
	private String price;
	private int quantity;
	private String category;
	private String order_placed_date;
	private String delivery_date;
	private String expected_del_date;
	private String COD;
	private boolean returnable;
	private String mode_of_return;
	private int returnable_days;
	private String condition;
	private long refund_amount;
	private String return_date;
	
	
	public String getReturn_date() {
		return return_date;
	}


	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}


	public long getRefund_amount() {
		return refund_amount;
	}


	public void setRefund_amount(long refund_amount) {
		this.refund_amount = refund_amount;
	}


	public boolean isReturnable() {
		return returnable;
	}


	public void setReturnable(boolean returnable) {
		this.returnable = returnable;
	}


	public String getMode_of_return() {
		return mode_of_return;
	}


	public void setMode_of_return(String mode_of_return) {
		this.mode_of_return = mode_of_return;
	}


	public int getReturnable_days() {
		return returnable_days;
	}


	public void setReturnable_days(int returnable_days) {
		this.returnable_days = returnable_days;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public String getType_name() {
		return type_name;
	}


	public void setType_name(String type_name) {
		this.type_name = type_name;
	}


	public String getASIN() {
		return ASIN;
	}


	public void setASIN(String aSIN) {
		ASIN = aSIN;
	}


	public String getPrice() {
		return price;
	}

	

	public void setPrice(String price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getOrder_placed_date() {
		return order_placed_date;
	}


	public void setOrder_placed_date(String order_placed_date) {
		this.order_placed_date = order_placed_date;
	}


	public String getDelivery_date() {
		return delivery_date;
	}


	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}


	public String getExpected_del_date() {
		return expected_del_date;
	}


	public void setExpected_del_date(String expected_del_date) {
		this.expected_del_date = expected_del_date;
	}


	public String getCOD() {
		return COD;
	}


	public void setCOD(String cOD) {
		COD = cOD;
	}



}
