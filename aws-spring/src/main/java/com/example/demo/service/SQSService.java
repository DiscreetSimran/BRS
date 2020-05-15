package com.example.demo.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.amazonaws.services.sqs.buffered.AmazonSQSBufferedAsyncClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.example.demo.database.DynamoDb;
import com.example.demo.repository.Order;
import com.example.demo.repository.RatingSystem;
import com.example.demo.repository.SQSMessage;
import com.example.demo.repository.Type;
import com.example.demo.strategy.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableSqs
@PropertySource(value = "application.yml")
@Service
public class SQSService {
	
	Logger logger = LoggerFactory.getLogger(SQSService.class);
		
	/*@Value("${cloud.aws.end-point.uri}")
	private String sqsEndPoint;*/
	
	private String sqsEndPoint="https://sqs.us-east-1.amazonaws.com/237142071300/newsqs.fifo";
	
	@Autowired
	private AmazonSQSBufferedAsyncClient amazonsqs;
	
	@Autowired(required=false)
	private Algorithm algorithm;
	
	@Autowired
	private DynamoDb dynamoDb;
	
	
	
	ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(sqsEndPoint)
			  .withWaitTimeSeconds(10)
			  .withMaxNumberOfMessages(10);
	
    @Async
	public void receiveMessage() throws JsonMappingException, JsonProcessingException {
		System.out.println("queue ="+ amazonsqs + " remsgreq = " + receiveMessageRequest);

		    final List<Message> messages = amazonsqs.receiveMessage(receiveMessageRequest).getMessages();

		    for (Message messageObject : messages) {
		    	
		    	logger.info("Current thread is "+ Thread.currentThread().getName());
		    	
		        String message = messageObject.getBody();
		        
		        ObjectMapper mapper = new ObjectMapper();
		        
		        SQSMessage sqsMessage = mapper.readValue(message, SQSMessage.class);
		        
		        for (Order Order : sqsMessage.getOrder()) {
		        	
		        	logger.info("this is = "+Order.getOrder_id());
		        	
		        	for(Type type : Order.getType()) {
		        		
		        	 logger.info("this is ="+ type.getType_name());
		        	 //logger.info("this is ="+type.getDelivery_date());
		        	 
		        	}
		        }
		        
		        logger.info("sqsmessage= "+sqsMessage);
		        		        
		        
		        Long cid = sqsMessage.getCid();
		       
		        logger.info("this is = "+cid);
		         
		         
		         RatingSystem bString = dynamoDb.getOneCustomerDetails(cid.toString());
		         
    
		         double rate = algorithm.logic(message, bString);
		
		         
		        logger.info("new_rating = "+ rate);
		        
		        logger.info("End of "+ Thread.currentThread().getName());
		        
		        
		        
		    
		}
		
	}
	
}

