package com.caps.sms.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dealer")
public class Dealer {
	@Id
	@Column(name="dealerId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int dealerId;
	
	@Column(name="dealerContactNo")
	private long dealerContactNo;
	
	@Column(name="dealerLocation")
	private String dealerLocation;
	
	@Column(name="dealerName")
	private String dealerName;
	
	@Column(name="dealerPassword")
	private String dealerPassword;

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public long getDealerContactNo() {
		return dealerContactNo;
	}

	public void setDealerContactNo(long dealerContactNo) {
		this.dealerContactNo = dealerContactNo;
	}

	public String getDealerLocation() {
		return dealerLocation;
	}

	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerPassword() {
		return dealerPassword;
	}

	public void setDealerPassword(String dealerPassword) {
		this.dealerPassword = dealerPassword;
	}

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerContactNo=" + dealerContactNo + ", dealerLocation="
				+ dealerLocation + ", dealerName=" + dealerName + ", dealerPassword=" + dealerPassword + "]";
	}
	
	
}
