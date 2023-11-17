package com.exception.example.demo.service;

import org.springframework.stereotype.Service;

import com.exception.example.demo.exception.NoProductFoundException;
import com.exception.example.demo.model.Product;

@Service
public class ProductService {
	
	public Product getAllProductsById(String id) {
		if(id=="101")
			return new Product("101", "test1", "test1");
		else
			throw new NoProductFoundException(id);
	}

}
