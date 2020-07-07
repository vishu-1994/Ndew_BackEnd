package com.ndew.work.model;

public class CustomerDTO {
	
	Integer custId;
	String name;
	Long phone;
	String email;
	String address;
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerDTO [custId=" + custId + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	

}
