package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long custId;
	private String custFirstName;
	private String custLastName;
	private String custEmail;
	private String custphone;
	private String custAddress;
	private String custCity;
	private int zip;
	private String custpassword;

	public Customer() {
		super();
	}

	public Customer(String custFirstName, String custLastName, String custEmail, String custphone, String custAddress,
			String custCity, int zip, String custpassword) {
		super();
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custEmail = custEmail;
		this.custphone = custphone;
		this.custAddress = custAddress;
		this.custCity = custCity;
		this.zip = zip;
		this.custpassword = custpassword;
	}

	public Customer(Long custId, String custFirstName, String custLastName, String custEmail, String custphone,
			String custAddress, String custCity, int zip, String custpassword) {
		super();
		this.custId = custId;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custEmail = custEmail;
		this.custphone = custphone;
		this.custAddress = custAddress;
		this.custCity = custCity;
		this.zip = zip;
		this.custpassword = custpassword;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustphone() {
		return custphone;
	}

	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCustpassword() {
		return custpassword;
	}

	public void setCustpassword(String custpassword) {
		this.custpassword = custpassword;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custFirstName=" + custFirstName + ", custLastName=" + custLastName
				+ ", custEmail=" + custEmail + ", custphone=" + custphone + ", custAddress=" + custAddress
				+ ", custCity=" + custCity + ", zip=" + zip + ", custpassword=" + custpassword + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		return true;
	}
}
