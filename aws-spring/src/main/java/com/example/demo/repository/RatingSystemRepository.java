package com.example.demo.repository;

public interface RatingSystemRepository<S,T> {
	void deleteCustomerDetails(S var1);
	S getOneCustomerDetails(T var1);
	void insertIntoDynamoDB(S var1);
	void updateCustomerDetails(S var1);

}

