package com.wipro.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Visa")
public class Visa {
	private String visaId;

	private String visaType;
	private String validFrom;
	private String validTo;
	private String country;

	@Id
	@Column(name="visaId")
	public String getVisaId() {
		return visaId;
	}
	public void setVisaId(String visaId) {
		this.visaId = visaId;
	}

	@Column(name="visaType")
	public String getVisaType() {
		return visaType;
	}
	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	@Column(name="validFrom")
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	@Column(name="validTo")
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
