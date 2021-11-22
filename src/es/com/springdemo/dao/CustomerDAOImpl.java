package es.com.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> customers = session.createQuery("from Customer order by last_name", Customer.class);

		List<Customer> list = customers.getResultList();

		return list;

	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:customerID");
		query.setParameter("customerID", id);
		
		query.executeUpdate();
		
	}
	
	

	

}
