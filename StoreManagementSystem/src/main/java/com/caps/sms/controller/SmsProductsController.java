package com.caps.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caps.sms.beans.Products;
import com.caps.sms.services.SmsServices;
import com.caps.sms.services.SmsServicesImpl;
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SmsProductsController {
	
	@Autowired
	SmsServices service = new SmsServicesImpl();

//working
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public String addProducts(@RequestBody  Products product) {
		
		boolean result = service.addProduct(product) ;
		System.out.println("workingsdnfklsdnflkdsnflks");
		System.out.println(result);
		if(result)
			return "{\"msg\": \"success\"}";
		else
			return "{\"msg\": \"failed\"}";		
	}

 //working
	@RequestMapping(value = "/get/product/{id}", method = RequestMethod.GET)
	public Products getProduct(@PathVariable("id")int id)
	{
		Products product = service.getProduct(id);
		System.out.println(product);
		return product;
	}
	@RequestMapping(value = "/productprice/{id}", method = RequestMethod.GET)
	public int productPrice(@PathVariable("id")int productId)
	{
		int  result = service.ProductPrice(productId) ;
		if(result >-1)
			return  result ;
		else
			return  0;
	}


	//working
	@RequestMapping(value = "/getAllproducts", method = RequestMethod.GET)
	public List<Products> getAll()
	{
		
		System.out.println("returned");
		return service.getProducts();
		
	}
//working
	@RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id")int id)
	{
		boolean result = service.deleteProduct(id) ;
		if(result)
			return "{\"msg\": \"success\"}";
		else
			return "{\"msg\": \"failed\"}";	
	}
	
	
	
	@RequestMapping(value = "/getproduct/update", method = RequestMethod.PUT)
	public boolean upDateProducts(@RequestBody  Products product)
	{
		
		System.out.println("before exe");	
	    boolean result = service.updateProduct(product.getManufacturerId(),product.getProductId(), product.getProductName(), product.getProductPrice(), product.getProductStock()) ;
	    return result ;
	
	}

}
