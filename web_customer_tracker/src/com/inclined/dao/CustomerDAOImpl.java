package com.inclined.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inclined.entity.Customer;
import com.inclined.utility.SortUtilities;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers(Integer SortField) {
		
		String sortBy;
		switch(SortField) {
			case SortUtilities.lastName:
				sortBy = "lastName";
				break;
			case SortUtilities.email:
				sortBy = "email";
				break;
			default:
				sortBy = "firstName";
		}

		Session session = sessionFactory.getCurrentSession();
		Query<Customer> getQuery = session.createQuery("from Customer order by "+sortBy, Customer.class);
		List<Customer> customers = getQuery.getResultList();
		return customers;
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from Customer c where c.id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
	}

	@Override
	public List<Customer> getCustomersByMatchingString(String searchQuery) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer c where lower(c.firstName) like :searchQuery or lower(c.lastName) like :searchQuery or lower(c.email) like :searchQuery order by c.firstName");
		query.setParameter("searchQuery", "%"+searchQuery.toLowerCase()+"%");
		return  query.getResultList();
	}

}
