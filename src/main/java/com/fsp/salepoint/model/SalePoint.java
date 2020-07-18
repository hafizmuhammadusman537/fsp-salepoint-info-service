package com.fsp.salepoint.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TBLSALEPOINT")
public class SalePoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SALEPOINT_ID")
	private Long id;

	@Column(name = "SALEPOINT_NAME", nullable = false)
	private String name;

	@Column(name = "SALEPOINTDELIVERYAREA_DISTANCE")
	private Float deliveryAreaDistance;

	@Column(name = "REGISTERED_AT")
	private Timestamp registeredAt;

	@Column(name = "CONFIRMED_AT")
	private Timestamp confirmedAt;

	@Column(name = "SALEPOINT_RANKING")
	private Float rating;

	@Column(name = "SALEPOINT_PHOTO")
	private String photo;

	@Column(name = "SALEPOINT_DESCRIPTION")
	private String description;


	@Column(name = "SALEPOINTOWNER_ID")
	private Long salePointOwner;

	@Column(name = "ISACTIVE")
	private Character isActive;

	@Column(name = "MODIFIED_BY")
	private Long modifiedBy;

	@Column(name = "MODIFIED_WHEN")
	private String modifiedWhen;

	@Column(name = "MODIFIED_WORKSTATION")
	private String modifiedWorkstation;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;

	public SalePoint() {
	}

	public SalePoint(String name, Float deliveryAreaDistance, Timestamp registeredAt, Timestamp confirmedAt, Float rating, String photo, String description, Long salePointOwner, Character isActive, Long modifiedBy, String modifiedWhen, String modifiedWorkstation, Address address)
	{
		this.name = name;
		this.deliveryAreaDistance = deliveryAreaDistance;
		this.registeredAt = registeredAt;
		this.confirmedAt = confirmedAt;
		this.rating = rating;
		this.photo = photo;
		this.description = description;
		this.salePointOwner = salePointOwner;
		this.isActive = isActive;
		this.modifiedBy = modifiedBy;
		this.modifiedWhen = modifiedWhen;
		this.modifiedWorkstation = modifiedWorkstation;
		this.address = address;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Float getDeliveryAreaDistance()
	{
		return deliveryAreaDistance;
	}

	public void setDeliveryAreaDistance(Float deliveryAreaDistance)
	{
		this.deliveryAreaDistance = deliveryAreaDistance;
	}

	public Timestamp getRegisteredAt()
	{
		return registeredAt;
	}

	public void setRegisteredAt(Timestamp registeredAt)
	{
		this.registeredAt = registeredAt;
	}

	public Timestamp getConfirmedAt()
	{
		return confirmedAt;
	}

	public void setConfirmedAt(Timestamp confirmedAt)
	{
		this.confirmedAt = confirmedAt;
	}

	public Float getRating()
	{
		return rating;
	}

	public void setRating(Float rating)
	{
		this.rating = rating;
	}

	public String getPhoto()
	{
		return photo;
	}

	public void setPhoto(String photo)
	{
		this.photo = photo;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Long getSalePointOwner()
	{
		return salePointOwner;
	}

	public void setSalePointOwner(Long salePointOwner)
	{
		this.salePointOwner = salePointOwner;
	}

	public Character getIsActive()
	{
		return isActive;
	}

	public void setIsActive(Character isActive)
	{
		this.isActive = isActive;
	}

	public Long getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedWhen()
	{
		return modifiedWhen;
	}

	public void setModifiedWhen(String modifiedWhen)
	{
		this.modifiedWhen = modifiedWhen;
	}

	public String getModifiedWorkstation()
	{
		return modifiedWorkstation;
	}

	public void setModifiedWorkstation(String modifiedWorkstation)
	{
		this.modifiedWorkstation = modifiedWorkstation;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}
}