package com.example.demo.strategy;

import com.example.demo.repository.RatingSystem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface Strategy {
	
	public double logic(String from_sqs, RatingSystem from_ddb) throws JsonMappingException, JsonProcessingException;

}
