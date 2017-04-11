package com.wipro.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeVisa")
public class EmployeeVisa {
	int assid;//association id
	
	int eid;//employee id
	String vid;//visa id
	
	@Id
	@GeneratedValue
	@Column(name="assID")
	public int getAssid() {
		return assid;
	}
	public void setAssid(int assid) {
		this.assid = assid;
	}
	
	@Column(name="eID")
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	@Column(name="VID")
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}

}
