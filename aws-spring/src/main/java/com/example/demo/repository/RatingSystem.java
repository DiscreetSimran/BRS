package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.context.annotation.ComponentScan;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "RatingSystem")
public class RatingSystem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String customerId;
	private double rating;
	private double amountBought;
	private double amountShipped;
	private double amountCancelled;
	private double amountReturned;
	private double fine;
	private boolean deliveryCharge;
	private int cancelledOrders;
	private int returnedOrders;
	private int boughtOrders;
	

	@DynamoDBHashKey(attributeName = "customerId")
	@DynamoDBAutoGeneratedKey
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	@DynamoDBAttribute
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	@DynamoDBAttribute
	public double getAmountBought() {
		return amountBought;
	}
	public void setAmountBought(double amountBought) {
		this.amountBought = amountBought;
	}
	
	@DynamoDBAttribute
	public double getAmountCancelled() {
		return amountCancelled;
	}
	public void setAmountCancelled(double amountCancelled) {
		this.amountCancelled = amountCancelled;
	}
	
	@DynamoDBAttribute
	public double getAmountReturned() {
		return amountReturned;
	}
	public void setAmountReturned(double amountReturned) {
		this.amountReturned = amountReturned;
	}
	
	@DynamoDBAttribute
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	
	@DynamoDBAttribute
	public boolean isDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(boolean deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	@DynamoDBAttribute
	public int getCancelledOrders() {
		return cancelledOrders;
	}

	public void setCancelledOrders(int cancelledOrders) {
		this.cancelledOrders = cancelledOrders;
	}

	@DynamoDBAttribute
	public int getReturnedOrders() {
		return returnedOrders;
	}

	public void setReturnedOrders(int returnedOrders) {
		this.returnedOrders = returnedOrders;
	}

	@DynamoDBAttribute
	public int getBoughtOrders() {
		return boughtOrders;
	}

	public void setBoughtOrders(int boughtOrders) {
		this.boughtOrders = boughtOrders;
	}
	
	@DynamoDBAttribute
	public double getAmountShipped() {
		return amountShipped;
	}
	public void setAmountShipped(double amountShipped) {
		this.amountShipped = amountShipped;
	}
	
	
}
