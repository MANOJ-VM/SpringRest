package com.caps.sms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caps.sms.beans.Dealer;
import com.caps.sms.beans.Manufacturer;
import com.caps.sms.beans.Products;
import com.caps.sms.dao.DealerDAO;
import com.caps.sms.dao.DealerDAOImpl;
import com.caps.sms.dao.ManufacturerDAO;
import com.caps.sms.dao.ManufacturerDAOImpl;
import com.caps.sms.dao.ProductsDAO;
import com.caps.sms.dao.ProductsDAOImpl;
@Service
public class SmsServicesImpl implements SmsServices{

	@Autowired
	DealerDAO  dea = new DealerDAOImpl();

	@Override
	public Dealer getDealer(int dealerId) {
		return dea.getDealer(dealerId);
	}

	@Override
	public boolean updateDealer(int dealerId, long dealerContactNo, String dealerLocation, String dealerName,
			String dealerPassword) {
		return dea.updateDealer(dealerId, dealerContactNo, dealerLocation, dealerName, dealerPassword);
	}

	@Override
	public Dealer loginDealer(int dealerId, String dealerPassword) {
		return dea.loginDealer(dealerId, dealerPassword);
	}

	@Override
	public boolean deleteDealer(int dealerId) {
		return dea.deleteDealer(dealerId);
	}

	@Override
	public List<Dealer> listAll() {
		return dea.listAll();
	}

	@Override
	public List<Dealer> getDealers() {
		return dea.getDealers();
	}

	@Autowired
	ManufacturerDAO  manufacture  = new ManufacturerDAOImpl() ;
	
	@Override
	public boolean addManufacturer(Manufacturer manufacturer) {
		return manufacture.addManufacturer(manufacturer);
	}

	@Override
	public Manufacturer getManufacturer(int manufacturerId) {
		return manufacture.getManufacturer(manufacturerId);
	}

	@Override
	public boolean updateManufacturer(int manufacturerId, long manufacturerContactNo, String manufacturerLocation,
			String manufacturerName, String manufactuererPassword) {
		return manufacture.updateManufacturer(manufacturerId, manufacturerContactNo, manufacturerLocation, manufacturerName, manufactuererPassword);
	}

	@Override
	public Manufacturer loginManufacturer(int manufacturerId, String manufacturerPassword) {
		return manufacture.loginManufacturer(manufacturerId, manufacturerPassword);
	}

	@Override
	public boolean deleteManufacturer(int manufacturerId) {
		return manufacture.deleteManufacturer(manufacturerId);
	}

	@Override
	public List<Manufacturer> getManufacturers() {
		return manufacture.getManufacturers();
	}

	@Override
	public boolean addDealer(Dealer dealer) {
		return dea.addDealer(dealer);
	}

	
	@Autowired
	ProductsDAO  product  = new ProductsDAOImpl() ;
	@Override
	public boolean addProduct(Products products) {
		return product.addProduct(products);
	}

	@Override
	public Products getProduct(int productId) {
		return product.getProduct(productId);
	}

	@Override
	public boolean updateProduct(int manufacturerId, int productId, String productName, int productPrice,
			int productStock) {
		return product.updateProduct(manufacturerId, productId, productName, productPrice, productStock);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return product.deleteProduct(productId);
	}

	@Override
	public int ProductPrice(int productId) {
		return product.ProductPrice(productId);
	}

	@Override
	public List<Products> getProducts() {
		return product.getProducts();
	}

	}

