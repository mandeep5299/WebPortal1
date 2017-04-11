package com.wipro.portal.controller;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.controller.AppService;
import com.wipro.portal.domain.Asset;

import com.wipro.portal.dao.AssetEntryDAO;
import com.wipro.portal.util.Parameter;
import com.wipro.portal.util.Validator;
import java.util.Map;



@Controller
@RequestMapping("/assetEntry.htm")
public class AssetEntryController extends BaseController { 

	private AssetEntryDAO assetentryDAO;


	@Autowired
	public void setAssetEntryDAO(AssetEntryDAO assetentryDAO) {

		this.assetentryDAO = assetentryDAO;

	}

	public String doGet(AppService appService) {
		ModelMap model = appService.getModelMap();
		model.addAttribute("Asset", new Asset());
		return "AssetEntry";
	}

	public String doPost(AppService appService) {
		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());
		HttpSession session=appService.getRequest().getSession();
		Asset asset=new Asset();
		asset.setAssetType(param.getString("assetType"));
		asset.setMacSerialNo(param.getString("macSerialNo"));
		asset.setAssetId(param.getString("assetId"));
		asset.setAssetBrand(param.getString("Brand"));
		asset.setAssetStatus("Free");
		Map errors = doValidate(asset);
		if (errors.isEmpty()) {
			assetentryDAO.saveAsset(asset);
			return "Success";
		}

		model.addAttribute("asset", asset);
		model.addAttribute("errors",errors);
		return "AssetEntry";

	}

	private Map<String, String> doValidate(Asset asset) {
		HashMap<String, String> errors = new HashMap<String, String>();

		if (Validator.isBlank(asset.getAssetType())) {
			errors.put("200", "Asset Type is required");
		}
		else if (Validator.isBlank(asset.getMacSerialNo())){
			errors.put("201","Mac Serial No Id is required");
		}
		else if (Validator.isBlank(asset.getAssetId())){
			errors.put("202","Asset Id is required");
		}
		else if (Validator.isBlank(asset.getAssetBrand())){
			errors.put("203","Brand is required");
		}

		return errors;
	}



}
