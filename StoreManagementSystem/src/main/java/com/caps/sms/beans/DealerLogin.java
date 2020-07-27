package com.caps.sms.beans;

public class DealerLogin {
	Dealer dealer = new Dealer();
	
	private int dealerId;
	private String dealerPassword;
	
	public int getDealerId() {
		return dealerId;
	}
	public void setDealerId(int dealerId) {
		dealer.setDealerId(dealerId);
	}
	public String getDealerPassword() {
		return dealerPassword;
	}
	public void setDealerPassword(String dealerPassword) {
		dealer.setDealerPassword(dealerPassword);
	}
	
	

}
