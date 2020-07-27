package com.caps.sms.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Devolution {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    private  int  mproductid  ;

	//@Id @GeneratedValue(generator="system-uuid")
	//@GenericGenerator(name="system-uuid", strategy = "uuid")
    
    
	
	@Column(name =  "mid")
	//	@NotNull
	private  	int mid  ;

	@Column(name =  "mproductname")
	//	@NotNull
	private  	String mproductname  ;

	@Column(name =  "mproductprice")
	//	@NotNull
	private  	int  mproductprice  ;
	
	
	
	@Column(name =  "mproductstock")
	//	@NotNull
	private  	int mproductstock  ;


}
