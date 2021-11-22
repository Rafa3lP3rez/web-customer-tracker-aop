package es.com.springdemo.dao;

import java.util.List;

import es.com.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void delete(int id);



}
