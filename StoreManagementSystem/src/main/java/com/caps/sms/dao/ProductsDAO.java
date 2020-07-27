package com.caps.sms.dao;
import java.util.List;

import com.caps.sms.beans.Products;

public interface ProductsDAO {
	public boolean addProduct(Products products);

	public Products getProduct(int productId);

	public boolean updateProduct( int manufacturerId ,int productId ,String productName , int productPrice , int  productStock);

	public boolean deleteProduct(int productId);
	
	public int ProductPrice(int productId);
	public List<Products>  getProducts();
}
