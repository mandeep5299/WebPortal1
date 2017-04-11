package com.wipro.portal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.wipro.portal.domain.Asset;

public interface SearchAssetDAO {
	public List<Asset> SearchAsset(HttpSession sesion);
}
