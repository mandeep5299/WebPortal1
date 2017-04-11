 package com.wipro.portal.dao;

import java.util.List;

import com.wipro.portal.domain.Asset;

public interface AssetEditDAO {
	 Asset searchAsset(String assetId) ;
	 Boolean updateAsset(Asset asset);
	 Boolean deleteAsset(Asset assetId) ;
	
	
}
