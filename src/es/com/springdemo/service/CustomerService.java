package es.com.springdemo.service;

import java.util.List;

import es.com.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void delete(int id);


	
}
