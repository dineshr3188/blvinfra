package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public String getAllCsutomer() {
		return "Hello Dinesh";
	}
	
}
