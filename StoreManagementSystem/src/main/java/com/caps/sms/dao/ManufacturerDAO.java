package com.caps.sms.dao;

import java.util.List;

import com.caps.sms.beans.Manufacturer;

public interface ManufacturerDAO {
	public boolean addManufacturer(Manufacturer manufacturer);

	public Manufacturer getManufacturer(int manufacturerId);

	public boolean updateManufacturer(int  manufacturerId ,long manufacturerContactNo ,String manufacturerLocation , String manufacturerName , String  manufactuererPassword);
	
	public Manufacturer loginManufacturer(int manufacturerId , String manufacturerPassword);


	public boolean deleteManufacturer(int manufacturerId);

	public List<Manufacturer> listAll();

	public List<Manufacturer>  getManufacturers() ;
}
