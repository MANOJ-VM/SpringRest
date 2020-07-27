package com.caps.sms.beans;

public class ManufacturerLogin {
	Manufacturer manufacturer = new Manufacturer();
	
	private int manufacturerId;
	private String manufacturerPassword;
	
	public int getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(int manufacturerId) {
		manufacturer.setManufacturerId(manufacturerId);
	}
	public String getManufacturerPassword() {
		return manufacturerPassword;
	}
	public void setManufacturerPassword(String manufacturerPassword) {
		manufacturer.setManufacturerPassword(manufacturerPassword);
	}
	
	

}
