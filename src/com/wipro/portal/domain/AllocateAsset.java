package com.wipro.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AllocateAsset")
public class AllocateAsset implements java.io.Serializable {
	private String employeeId;
	private String cpuId;
	private String mouseId;
	private String monitorId;
	private String keyboardId;
	private String allocatedDate;
	private String allocatedTo;
	private String allocatedBy;
	private String createdDate;
	private String updationDate;
	
	@Id
	@Column(name = "employeeId")
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	@Column(name = "cpuId")
	public String getCpuId() {
		return cpuId;
	}
	public void setCpuId(String cpuId) {
		this.cpuId = cpuId;
	}
	@Column(name = "mouseId")
	public String getMouseId() {
		return mouseId;
	}
	public void setMouseId(String mouseId) {
		this.mouseId = mouseId;
	}
	@Column(name = "monitorId")
	public String getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}
	@Column(name = "keyboardId")
	public String getKeyboardId() {
		return keyboardId;
	}
	public void setKeyboardId(String keyboardId) {
		this.keyboardId = keyboardId;
	}
	@Column(name = "allocatedDate")
	public String getAllocatedDate() {
		return allocatedDate;
	}
	public void setAllocatedDate(String allocatedDate) {
		this.allocatedDate = allocatedDate;
	}
	@Column(name = "allocatedTo")
	public String getAllocatedTo() {
		return allocatedTo;
	}
	public void setAllocatedTo(String allocatedTo) {
		this.allocatedTo = allocatedTo;
	}
	@Column(name = "allocatedBy")
	public String getAllocatedBy() {
		return allocatedBy;
	}
	public void setAllocatedBy(String allocatedBy) {
		this.allocatedBy = allocatedBy;
	}
	@Column(name = "createdDate")
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Column(name = "updationDate")
	public String getUpdationDate() {
		return updationDate;
	}
	public void setUpdationDate(String updationDate) {
		this.updationDate = updationDate;
	}
	
	
	
}