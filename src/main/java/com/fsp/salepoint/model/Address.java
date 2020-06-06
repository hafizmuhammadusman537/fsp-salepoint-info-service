
package com.fsp.salepoint.model;

import javax.persistence.*;

@Entity
@Table(name = "TBLADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private Long id;

	@Column(name = "ADDRESS_LONGITUDE")
	private Float longitude;

	@Column(name = "ADDRESS_LATITUDE")
	private Float latitude;

	@Column(name = "ADDRESS_STATE")
	private String state;

	@Column(name = "ADDRESS_COUNTRY")
	private String country;

	@Column(name = "ADDRESS_POSTAL")
	private String postalAddress;

	@Column(name = "CITY")
	private String city;

	@Column(name = "POSTAL_CODE")
	private Integer postalCode;

	public Address() {
	}

	public Address(Float longitude, Float latitude, String state, String country, String postalAddress, String city, Integer postalCode)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.state = state;
		this.country = country;
		this.postalAddress = postalAddress;
		this.city = city;
		this.postalCode = postalCode;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Float getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Float longitude)
	{
		this.longitude = longitude;
	}

	public Float getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Float latitude)
	{
		this.latitude = latitude;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getPostalAddress()
	{
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress)
	{
		this.postalAddress = postalAddress;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Integer getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(Integer postalCode)
	{
		this.postalCode = postalCode;
	}
}
