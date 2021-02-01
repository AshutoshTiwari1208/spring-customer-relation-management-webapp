package com.inclined.services;

import java.util.List;

import com.inclined.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(Integer sortField);

	public void save(Customer customer);

	public Customer getCustomer(Integer id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String searchQuery);
}
