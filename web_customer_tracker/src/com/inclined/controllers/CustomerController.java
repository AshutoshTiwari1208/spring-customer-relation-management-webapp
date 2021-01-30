package com.inclined.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	

	@RequestMapping("/list")
	public String getCustomersList() {
		return "CustomersList";
	}

}
