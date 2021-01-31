package com.inclined.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inclined.entity.Customer;
import com.inclined.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String getCustomersList(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "CustomersList";
	}
	
	@GetMapping("/addCustomerForm")
	public String getAddCustomerForm(Model model) {
		Customer newCustomer = new Customer();
		model.addAttribute("customer", newCustomer);
		return "CustomerForm";
	}
	
	@PostMapping("/saveForm")
	public String saveForm(@ModelAttribute("customer")Customer customer) {
		return "redirect:/customer/list";
	}

}
