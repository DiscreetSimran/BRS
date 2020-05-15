package com.example.demo.strategy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.Order;
import com.example.demo.repository.RatingSystem;
import com.example.demo.repository.SQSMessage;
import com.example.demo.repository.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Algorithm implements Strategy{
	
	Logger logger = LoggerFactory.getLogger(Algorithm.class);
	
	public double logic(String from_sqs, RatingSystem from_Ddb) throws JsonMappingException, JsonProcessingException {
		
		double amountBought = from_Ddb.getAmountBought();
		int boughtOrders = from_Ddb.getBoughtOrders();
		double amountCancelled = from_Ddb.getAmountCancelled();
		int cancelledOrders = from_Ddb.getCancelledOrders();
		double amountReturned = from_Ddb.getAmountReturned();
		int returnedOrders = from_Ddb.getReturnedOrders();
		double old_rating =4.0;
	   double new_rating=0.0;
	   String order_id;
	   String type_name = null;
	   String price = null;
	   int quantity = 0;
	   
	   ObjectMapper mapper = new ObjectMapper();
       SQSMessage sqsMessage = mapper.readValue(from_sqs, SQSMessage.class);
	   
       
       Long cid = sqsMessage.getCid();
       for (Order Order : sqsMessage.getOrder()) {
       		order_id=Order.getOrder_id();
       		for(Type type : Order.getType()) {
       			type_name=type.getType_name();
       			price=type.getPrice();
       			quantity=type.getQuantity();
       		}
       }
       
       double amt=Integer.parseInt(price)*quantity;
       double total_amt=1000.0;
       
       switch(type_name) {
       case "shipped":
    	   if(amt>10000) {
        	   new_rating=old_rating+0.5;
           }
           else {
        	   new_rating=old_rating+0.3;
           }
    	   break;
       case "returned":
    	   if((amt/total_amt)>0.75) {
        	   new_rating=old_rating-0.5;
           }
           else {
        	   new_rating=old_rating-0.3;
           }
    	   break;
       case "cancelled":
    	   if((amt/total_amt)>0.75) {
        	   new_rating=old_rating-0.5;
           }
           else {
        	   new_rating=old_rating-0.3;
           }
    	   break;
       }
       
       
		return new_rating;
	}
	
}


