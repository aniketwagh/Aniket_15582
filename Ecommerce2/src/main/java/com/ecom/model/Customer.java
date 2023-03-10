package com.ecom.model;

public class Customer {
	private static int counter=1;
	private int custId;
	private String custName;
	private String custEmail;
	private double walletBalance;
	private long phoneNo;
	public Customer() {
		super();
	}
	public Customer(String custName, String custEmail, double walletBalance, long phoneNo) {
		super();
		this.custId=counter++;
		this.custName = custName;
		this.custEmail = custEmail;
		this.walletBalance = walletBalance;
		this.phoneNo = phoneNo;
	}
	public Customer(int custId, String custName, String custEmail, double walletBalance, long phoneNo) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.walletBalance = walletBalance;
		this.phoneNo = phoneNo;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public double getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", walletBalance="
				+ walletBalance + ", phoneNo=" + phoneNo + "]";
	}
}
