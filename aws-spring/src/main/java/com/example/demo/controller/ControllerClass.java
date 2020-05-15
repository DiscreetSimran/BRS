package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.SQSService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class ControllerClass {
	
	Logger logger = LoggerFactory.getLogger(ControllerClass.class);
	
	@Autowired(required=false)
	private SQSService sqsService;
	
	
	
	@GetMapping
	public String display() throws JsonMappingException, JsonProcessingException {
		sqsService.receiveMessage();
		return "hello.html";
	}
	
}
