package com.inclined.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inclined.entity.Customer;
import com.inclined.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String getCustomersList(@RequestParam(name="sort",required=false)String sort, Model model) {
		
		List<Customer> customers;
		int sortField = sort!=null ? Integer.parseInt(sort) : 1;
		customers = customerService.getCustomers(sortField);
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
		customerService.save(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomerForm")
	public String getUpdateCustomerForm(@RequestParam("customerId")Integer id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "CustomerForm";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("searchQuery")String searchQuery, Model model) {
		List<Customer> customers = customerService.searchCustomers(searchQuery);
		model.addAttribute("customers", customers);
		boolean isNonEmptyString = searchQuery.length()==0? false: true;
		model.addAttribute("search", isNonEmptyString);
		return "CustomersList";
	}
		
}
