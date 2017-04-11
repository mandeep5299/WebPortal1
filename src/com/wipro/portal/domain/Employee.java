package com.wipro.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements java.io.Serializable {

	private int employeeID;
	private String name;
	private String businessUnit;
	private String status;
	private long contactNo;
	private String aimMailID;
	private String wiproMailID;
	private String aimChatID;
	private String appleMailID;

	@Id
	@Column(name = "EmployeeID")
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeId) {
		this.employeeID = employeeId;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "BusinessUnit")
	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	@Column(name = "Status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "ContactNo")
	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "AIMMailID")
	public String getAimMailID() {
		return aimMailID;
	}

	public void setAimMailID(String aimMailID) {
		this.aimMailID = aimMailID;
	}

	@Column(name = "WiproMailID")
	public String getWiproMailID() {
		return wiproMailID;
	}

	public void setWiproMailID(String wiproMailID) {
		this.wiproMailID = wiproMailID;
	}

	@Column(name = "AIMChatID")
	public String getAimChatID() {
		return aimChatID;
	}

	public void setAimChatID(String aimChatID) {
		this.aimChatID = aimChatID;
	}

	@Column(name = "AppleMailID")
	public String getAppleMailID() {
		return appleMailID;
	}

	public void setAppleMailID(String appleMailID) {
		this.appleMailID = appleMailID;
	}

}