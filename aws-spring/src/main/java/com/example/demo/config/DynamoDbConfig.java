package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@PropertySource(value="application.yml")
@Configuration
public class DynamoDbConfig {

	//@Value("${amazon.access.key}")
	private String awsAccessKey="access - key";

	//@Value("${amazon.access.secret-key}")
	private String awsSecretKey="secret - key";

	//@Value("${amazon.region}")
	private String awsRegion="us-east-1";

	//@Value("${amazon.end-point.url}")
	private String awsDynamoDBEndPoint="dynamodb.us-east-1.amazonaws.com";
	
	
	
	//AWSCredentials credentials = new BasicAWSCredentials(
		//	  
			//);

	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());
	}

	public AmazonDynamoDB amazonDynamoDBConfig() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration( new AwsClientBuilder.EndpointConfiguration( awsDynamoDBEndPoint,awsRegion))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
				.build();
	}
}
