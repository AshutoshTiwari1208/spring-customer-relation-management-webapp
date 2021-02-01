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
	public List<Customer> getCustomers(Integer sortField) {
		return customerDAO.getCustomers(sortField);
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

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchQuery) {
		return customerDAO.getCustomersByMatchingString(searchQuery);
	}

}
