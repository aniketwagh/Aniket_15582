package com.Ecom.model;

public class Customer {
	
	private int custid;
	private String custname;
	private String custemail;
	private int custphone;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String custname, String custemail, int custphone) {
		super();
		this.custname = custname;
		this.custemail = custemail;
		this.custphone = custphone;
	}
	public Customer(int custid, String custname, String custemail, int custphone) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.custemail = custemail;
		this.custphone = custphone;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustemail() {
		return custemail;
	}
	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}
	public int getCustphone() {
		return custphone;
	}
	public void setCustphone(int custphone) {
		this.custphone = custphone;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", custemail=" + custemail + ", custphone="
				+ custphone + "]";
	}
	
	

}
