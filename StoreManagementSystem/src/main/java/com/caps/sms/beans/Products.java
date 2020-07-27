package com.caps.sms.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productId")
	private int productId;
	
	@Column(name="manufacturerId")
	private int manufacturerId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productPrice")
	private int productPrice;
	
	@Column(name="productStock")
	private int productStock;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", manufacturerId=" + manufacturerId + ", productName="
				+ productName + ", productPrice=" + productPrice + ", productStock=" + productStock + "]";
	}
	
	
}
