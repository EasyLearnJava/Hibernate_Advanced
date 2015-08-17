package com.easylearnjava.hibernate.dto;

public class Address {

	private int addressId;
	private String streetOne;
	private String streetTwo;
	private String city;
	private String state;
	private String zip;
	private Employee employee;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreetOne() {
		return streetOne;
	}

	public void setStreetOne(String streetOne) {
		this.streetOne = streetOne;
	}

	public String getStreetTwo() {
		return streetTwo;
	}

	public void setStreetTwo(String streetTwo) {
		this.streetTwo = streetTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Address(int addressId, String streetOne, String streetTwo,
			String city, String state, String zip, Employee employee) {
		
		this.addressId = addressId;
		this.streetOne = streetOne;
		this.streetTwo = streetTwo;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.employee = employee;
	}
	
	public Address(){
		
	}

}
