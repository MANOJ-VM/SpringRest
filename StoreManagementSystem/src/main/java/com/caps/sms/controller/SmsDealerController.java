package com.caps.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caps.sms.beans.Dealer;
import com.caps.sms.beans.DealerLogin;
import com.caps.sms.services.SmsServices;
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SmsDealerController {

	@Autowired
	SmsServices service ;
	//	= new SmsServicesImpl();



	//working
	@RequestMapping(value = "/savedealer", method = RequestMethod.POST)
	public String addDealer(@RequestBody  Dealer dealer) {


		System.out.println("comingggggggggggggg");
		System.out.println(dealer.getDealerLocation());


		boolean result = service.addDealer(dealer) ;
		System.out.println("workingsdnfklsdnflkdsnflks");
		System.out.println(result);
		if(result)
			return "{\"msg\": \"success\"}";
		else
			return "{\"msg\": \"failed\"}";	
	}

	//working
	@RequestMapping(value = "/get/dealer/{id}", method = RequestMethod.GET)
	public Dealer getDealer(@PathVariable("id")int id)
	{
		Dealer dealer = service.getDealer(id);
		System.out.println(dealer);
		return dealer;
	}

	//working
	@RequestMapping(value="/get/dealerlogin", method = RequestMethod.POST)
	public Dealer dealerLogin(@RequestBody DealerLogin dealerLogin)
	{
		Dealer dealer = null;
		//if(dealer.getDealerPassword().equals(password))
		
//		Dealer
		dealer = service.loginDealer(dealerLogin.getDealerId(),dealerLogin.getDealerPassword());
		if(dealer != null) {

			System.out.println(dealer);
			return dealer;
		}
		return dealer ;
	}

	//working
	@RequestMapping(value = "/getAllDealers", method = RequestMethod.GET)
	public List<Dealer> getAll()
	{

		System.out.println("returned");
		return service.getDealers();

	}
	//working
	@RequestMapping(value="/deletedealer/{id}",method = RequestMethod.DELETE)
	public String delete(@PathVariable("id")int id)
	{
		boolean result = service.deleteDealer(id);
		if(result)
			return "Success";
		else
			return "false";
	}



	@RequestMapping(value = "/getdealer/update", method = RequestMethod.PUT)
	public boolean upDateDealer(@RequestBody  Dealer dealer)
	{

		boolean  result = service.updateDealer(dealer.getDealerId() ,  dealer.getDealerContactNo() , 
				dealer.getDealerLocation() ,   dealer.getDealerName() ,dealer.getDealerPassword());
		return result ;
	}
}
