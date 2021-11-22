package es.com.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.com.springdemo.dao.CustomerDAO;
import es.com.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomer();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {

		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		customerDAO.delete(id);
	}


}
