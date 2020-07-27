package com.caps.sms.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manufacturer")
public class Manufacturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="manufacturerId")
 private int manufacturerId;
	
	@Column(name="manufacturerName")
 private String manufacturerName;
	
	@Column(name="manufacturerLocation")
 private String manufacturerLocation;
	
	@Column(name="manufacturerContactNo")
 private long manufacturerContactNo;
	
	@Column(name="manufacturerPassword")
 private String manufacturerPassword;

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerLocation() {
		return manufacturerLocation;
	}

	public void setManufacturerLocation(String manufacturerLocation) {
		this.manufacturerLocation = manufacturerLocation;
	}

	public long getManufacturerContactNo() {
		return manufacturerContactNo;
	}

	public void setManufacturerContactNo(long manufacturerContactNo) {
		this.manufacturerContactNo = manufacturerContactNo;
	}

	public String getManufacturerPassword() {
		return manufacturerPassword;
	}

	public void setManufacturerPassword(String manufacturerPassword) {
		this.manufacturerPassword = manufacturerPassword;
	}

	@Override
	public String toString() {
		return "Manufacturer [manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", manufacturerLocation=" + manufacturerLocation + ", manufacturerContactNo=" + manufacturerContactNo
				+ ", manufacturerPassword=" + manufacturerPassword + "]";
	}
	
}
