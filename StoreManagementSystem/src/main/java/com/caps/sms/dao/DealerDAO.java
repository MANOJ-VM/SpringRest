package com.caps.sms.dao;

import java.util.List;

import com.caps.sms.beans.Dealer;

public interface DealerDAO {
	public boolean addDealer(Dealer dealer);

	public Dealer getDealer(int dealerId);

	public boolean updateDealer(int  dealerId ,long dealerContactNo ,String dealerLocation , String dealerName , String  dealerPassword);
	
	public Dealer loginDealer(int dealerId , String dealerPassword);


	public boolean deleteDealer(int dealerId);

	public List<Dealer> listAll();

	public List<Dealer>  getDealers() ;
}
