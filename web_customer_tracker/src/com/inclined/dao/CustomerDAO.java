package com.inclined.dao;

import java.util.List;

import com.inclined.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void save(Customer customer);

	public Customer getCustomer(Integer id);
}
