package com.wipro.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Asset")
public class Asset implements java.io.Serializable {
	private String assetType;
	private String assetId;
	private String assetBrand;
	private String macSerialNo ;
	private String assetStatus;
	
	

	@Column(name = "AssetType")
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	@Id
	@Column(name = "AssetId")
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	@Column(name = "AssetBrand")
	public String getAssetBrand() {
		return assetBrand;
	}
	public void setAssetBrand(String assetBrand) {
		this.assetBrand = assetBrand;
	}
	@Column(name = "MacSerialNo")
	public String getMacSerialNo() {
		return macSerialNo;
	}
	public void setMacSerialNo(String macSerialNo) {
		this.macSerialNo = macSerialNo;
	}
	@Column(name = "AssetStatus")
	public String getAssetStatus() {
		return assetStatus;
	}
	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}
	
	
}