package com.banquemisr.irrigation.dao;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
private String street;
private String zipCode;
private String country;
  
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public Location(String street, String zipCode, String country) {
	super();
	this.street = street;
	this.zipCode = zipCode;
	this.country = country;
}
}
