package com.wipro.portal.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

public class MultiPartFileUploadBean {

	private String trainingname;
	private String trainingdescription;
	private String prerequistics;
	private String date;
	private String time;
	private String venue;
	private long contactperson;
	private int employeeId;
	private int trainingId;
	private String attachFile1;
	private String attachFile2;
	private String attachFile3;

	@Id
	@Column(name = "trainingId")
	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	@Column(name = "employeeId")
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "trainingname")
	public String getTrainingname() {
		return trainingname;
	}

	public void setTrainingname(String trainingname) {
		this.trainingname = trainingname;
	}

	@Column(name = "trainingdescription")
	public String getTrainingdescription() {
		return trainingdescription;
	}

	public void setTrainingdescription(String trainingdescription) {
		this.trainingdescription = trainingdescription;
	}

	@Column(name = "prerequistics")
	public String getPrerequistics() {
		return prerequistics;
	}

	public void setPrerequistics(String prerequistics) {
		this.prerequistics = prerequistics;
	}

	@Column(name = "date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "time")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "venue")
	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	@Column(name = "contactperson")
	public long getContactperson() {
		return contactperson;
	}

	public void setContactperson(long contactperson) {
		this.contactperson = contactperson;
	}

	@Column(name = "attachFile1")
	public String getAttachFile1() {
		return attachFile1;
	}

	public void setAttachFile1(String attachFile1) {
		this.attachFile1 = attachFile1;
	}

	@Column(name = "attachFile2")
	public String getAttachFile2() {
		return attachFile2;
	}

	public void setAttachFile2(String attachFile2) {
		this.attachFile2 = attachFile2;
	}

	@Column(name = "attachFile3")
	public String getAttachFile3() {
		return attachFile3;
	}

	public void setAttachFile3(String attachFile3) {
		this.attachFile3 = attachFile3;
	}

	private List<MultipartFile> files;

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}
}
