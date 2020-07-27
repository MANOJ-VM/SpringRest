package com.caps.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caps.sms.beans.Manufacturer;
import com.caps.sms.beans.ManufacturerLogin;
import com.caps.sms.services.SmsServicesImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class SmsManufactureController {

	@Autowired
	SmsServicesImpl service = new SmsServicesImpl();

	@RequestMapping(value = "/savemanufacturer", method = RequestMethod.POST)
	public String addManufacturer(@RequestBody Manufacturer manufacturer) {

		boolean result = service.addManufacturer(manufacturer);
		System.out.println("workingsdnfklsdnflkdsnflks");
		System.out.println(result);
		if (result)
			return "{\"msg\": \"success\"}";
		else
			return "{\"msg\": \"failed\"}";
	}

	@RequestMapping(value = "/get/manufacturer/{id}", method = RequestMethod.GET)
	public Manufacturer getManufacturer(@PathVariable("id") int id) {
		Manufacturer manufacturer = service.getManufacturer(id);
		System.out.println(manufacturer);
		return manufacturer;
	}

	@RequestMapping(value = "/get/loginmanufacturer", method = RequestMethod.POST)
	public Manufacturer manufacturerLogin(@RequestBody ManufacturerLogin manufacturerLogin) {

		Manufacturer manufacturer = service.loginManufacturer(manufacturerLogin.getManufacturerId(),
				manufacturerLogin.getManufacturerPassword());
		if (manufacturer != null) {

			return manufacturer;
		}
		return null;
	}

	@RequestMapping(value = "/getAllManufacturers", method = RequestMethod.GET)
	public List<Manufacturer> getAll() {

		System.out.println("returned");
		return service.getManufacturers();
		// System.out.println("returned");
	}

	// working
	@RequestMapping(value = "/deletemanufacturer/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") int id) {
		boolean res = service.deleteManufacturer(id);
		if (res)
			return "Success";
		else
			return "false";
	}

	@RequestMapping(value = "/getmanufacturer/update", method = RequestMethod.PUT)
	public boolean upDateManufacturer(@RequestBody Manufacturer manufacturer) {

		System.out.println("before exe");
		boolean result = service.updateManufacturer(manufacturer.getManufacturerId(),
				manufacturer.getManufacturerContactNo(), manufacturer.getManufacturerLocation(),
				manufacturer.getManufacturerName(), manufacturer.getManufacturerPassword());
		return result;
	}

}
