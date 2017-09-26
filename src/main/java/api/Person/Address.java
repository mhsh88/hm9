package api.Person;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8677569517811983186L;
	private String province;
	private String city;
	private String mainStreet;
	private String street;
	private int number;
	private long zipCode;
	
	public Address() {
		super();
	}
	public Address(String province, String city, String mainStreet, String street, int number, long zipCode) {
		this.province = province;
		this.city = city;
		this.mainStreet = mainStreet;
		this.street = street;
		this.number = number;
		this.zipCode = zipCode;
		
	}

	public String getProvince() {
		return province;
	}
	
	
	

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMainStreet() {
		return mainStreet;
	}

	public void setMainStreet(String mainStreet) {
		this.mainStreet = mainStreet;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
