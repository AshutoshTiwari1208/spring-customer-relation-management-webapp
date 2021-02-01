package com.inclined.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inclined.dao.CustomerDAO;
import com.inclined.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.save(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer id) {
		Customer customer = customerDAO.getCustomer(id);
		return customer;
	}

}
