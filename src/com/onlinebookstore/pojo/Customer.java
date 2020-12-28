package com.onlinebookstore.pojo;

public class Customer 
{
private int customerId;
private String customerName;
private String mobNo;
private String address;
private String emailID;
private String password;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getMobNo() {
	return mobNo;
}
public void setMobNo(String mobNo) {
	this.mobNo = mobNo;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmailID() {
	return emailID;
}
public void setEmailID(String emailID) {
	this.emailID = emailID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String toString() {
	return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobNo=" + mobNo + ", address="
			+ address + ", emailID=" + emailID + ", password=" + password + "]";
}


}
