package com.inclined.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inclined.dao.CustomerDAO;
import com.inclined.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String getCustomersList(Model model) {
		List<Customer> customers = customerDAO.getCustomers();
		model.addAttribute("customers", customers);
		return "CustomersList";
	}

}
