package com.wipro.portal.dao;

import java.util.List;

import com.wipro.portal.domain.Asset;
import com.wipro.portal.domain.Employee;

public interface AssetListDAO {
	public List<Asset> ListAsset();
	public List<Asset> ListAllocatedAssetsToFree();
	 List findFreeAssetListByassetType(String assetType);

}