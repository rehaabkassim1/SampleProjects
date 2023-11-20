package com.exception.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exception.example.demo.model.Product;
import com.exception.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/getProduct",produces = {"application/json"})
	public Product getProductById(@RequestParam("pid") String id) {
		return  productService.getAllProductsById(Integer.parseInt(id));
	}

}
