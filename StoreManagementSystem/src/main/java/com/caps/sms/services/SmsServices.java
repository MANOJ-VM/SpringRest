package com.caps.sms.services;

import java.util.List;

import com.caps.sms.beans.Dealer;
import com.caps.sms.beans.Manufacturer;
import com.caps.sms.beans.Products;

public interface SmsServices {
	public boolean addDealer(Dealer dealer);

	public Dealer getDealer(int dealerId);

	public boolean updateDealer(int  dealerId ,long dealerContactNo ,String dealerLocation , String dealerName , String  dealerPassword);
	
	public Dealer loginDealer(int dealerId , String dealerPassword);


	public boolean deleteDealer(int dealerId);

	public List<Dealer> listAll();

	public List<Dealer>  getDealers() ;
	
	//manufacturers
	public boolean addManufacturer(Manufacturer manufacturer);

	public Manufacturer getManufacturer(int manufacturerId);

	public boolean updateManufacturer(int  manufacturerId ,long manufacturerContactNo ,String manufacturerLocation , String manufacturerName , String  manufactuererPassword);
	
	public Manufacturer loginManufacturer(int manufacturerId , String manufacturerPassword);


	public boolean deleteManufacturer(int manufacturerId);

	public List<Manufacturer>  getManufacturers() ;
	
	
	//products

		public boolean addProduct(Products products);

		public Products getProduct(int productId);

		public boolean updateProduct( int manufacturerId ,int productId ,String productName , int productPrice , int  productStock);

		public boolean deleteProduct(int productId);
		
		public int ProductPrice(int productId);
		public List<Products>  getProducts();
	}

	