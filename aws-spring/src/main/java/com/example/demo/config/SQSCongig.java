package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.buffered.AmazonSQSBufferedAsyncClient;

@Configuration
@PropertySource(value = "application.yml")
public class SQSCongig {

	/*@Value("${cloud.aws.credentials.access-key}")
	private String awsAccessKey;
	
	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;*/
	
	String awsAccessKey = "access key";
	String awsSecretKey = "secret - key";
		
	@Bean
	public AmazonSQSBufferedAsyncClient amazonSQS() {
		return new AmazonSQSBufferedAsyncClient(amazonSQSAsync());
	}

	public AmazonSQSAsync amazonSQSAsync() {
		
		return AmazonSQSAsyncClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
				.withRegion(Regions.US_EAST_1)
				.build();
	}
	

}
