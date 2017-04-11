package com.wipro.portal.dao;

import com.wipro.portal.domain.AllocateAsset;

public interface AssetAllocateDAO {
	public void saveAllocateAsset(AllocateAsset asset);
	public AllocateAsset searchAllocatedAssetData(String assetId, String assetType);
	public AllocateAsset searchAllocatedAssetData(String searchEmployeeId);
	public Boolean updateAllocatedAsset(AllocateAsset allocateasset);
}