package com.wipro.portal.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.controller.AppService;
import com.wipro.portal.domain.AllocateAsset;
import com.wipro.portal.domain.Asset;

import com.wipro.portal.dao.AllocateToAssetDAO;
import com.wipro.portal.dao.AssetAllocateDAO;
import com.wipro.portal.dao.AssetEditDAO;
import com.wipro.portal.dao.AssetListDAO;
import com.wipro.portal.util.Parameter;
import com.wipro.portal.util.Validator;
import java.util.Map;

@Controller
@RequestMapping("/AllocateAsset.htm")
public class AssetAllocateController extends BaseController { 

	private AssetAllocateDAO assetallocateDAO;
	private AssetEditDAO asseteditDAO;
	private AssetListDAO assetlistDAO;

	
	@Autowired
	public void setAssetlistDAO(AssetListDAO assetlistDAO) {
		this.assetlistDAO = assetlistDAO;
	}

	@Autowired
	public void setAsseteditDAO(AssetEditDAO asseteditDAO) {
		this.asseteditDAO = asseteditDAO;
	}

	@Autowired
	public void setAssetallocateDAO(AssetAllocateDAO assetallocateDAO) {
		this.assetallocateDAO = assetallocateDAO;
	}

	public String doGet(AppService appService) {
		
		ModelMap model = appService.getModelMap();
		List freeCPUList = assetlistDAO.findFreeAssetListByassetType("CPU");
		model.addAttribute("freeCPUList", freeCPUList);
		List freeKeyboardList = assetlistDAO.findFreeAssetListByassetType("KEYBOARD");
		model.addAttribute("freeKeyboardList", freeKeyboardList);
		List freeMonitorList = assetlistDAO.findFreeAssetListByassetType("MONITOR");
		model.addAttribute("freeMonitorList", freeMonitorList);
		List freeMouseList = assetlistDAO.findFreeAssetListByassetType("MOUSE");
		model.addAttribute("freeMouseList", freeMouseList);
	  	return "AllocateAsset";
	}

	public String doPost(AppService appService) {
		_log.info("AssetToAllocate Controller : doPost Called");
		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());
		HttpSession session=appService.getRequest().getSession();
		AllocateAsset allocateasset = new AllocateAsset();
		allocateasset.setAllocatedBy(param.getString("allocatedBy"));
		allocateasset.setAllocatedTo(param.getString("allocatedTo"));
		allocateasset.setEmployeeId(param.getString("employeeId"));
		allocateasset.setAllocatedDate(param.getString("allocatedDate"));
		String cpuId = param.getString("cpuId");
		String mouseId = param.getString("mouseId");
		String monitorId = param.getString("monitorId");
		String keyboardId = param.getString("keyboardId");
		
		if(cpuId !=null && !cpuId.equals("")) {
			allocateasset.setCpuId(param.getString("cpuId"));
		}
		if(mouseId !=null && !mouseId.equals("")) {
			allocateasset.setMouseId(param.getString("mouseId"));
		}
		if(monitorId !=null && !monitorId.equals("")) {
			allocateasset.setMonitorId(param.getString("monitorId"));
		}
		if(keyboardId !=null && !keyboardId.equals("")) {
			allocateasset.setKeyboardId(param.getString("keyboardId"));
		}
		
		allocateasset.setCreatedDate(param.getString("createdDate"));
		allocateasset.setUpdationDate(param.getString("updatedDate"));
	
	 
		Map errors = doValidate(allocateasset);
		if (errors.isEmpty()) {
			
			assetallocateDAO.saveAllocateAsset(allocateasset);
			

			if(cpuId !=null && !cpuId.equals("")) {
				updateAssetStatus(cpuId);
			}

			if(mouseId !=null && !mouseId.equals("")) {
				updateAssetStatus(mouseId);
			}

			if(monitorId !=null && !monitorId.equals("")) {
				updateAssetStatus(monitorId);
			}

			if(keyboardId !=null && !keyboardId.equals("")) {
				updateAssetStatus(keyboardId);
			}
			
			return "Success";
		}
		
		model.addAttribute("asset", allocateasset);
		model.addAttribute("errors",errors);
		
		return "AllocateAsset";

	}
	
	public void updateAssetStatus(String assetId) {
		System.out.println("assetId ----"+assetId);
		Asset asset = (Asset) asseteditDAO.searchAsset(assetId);
		asset.setAssetStatus("Allocated");
		asseteditDAO.updateAsset(asset);
		
	}
	
	private Map<String, String> doValidate(AllocateAsset allocateasset) {
		HashMap<String, String> errors = new HashMap<String, String>();

		/*if (Validator.isBlank(allocateasset.getCpuId())) {
			errors.put("200", "Asset Name is required");
		}
		if (Validator.isBlank(allocateasset.getAllocatedBy())){
			errors.put("201","Asset Id is required");
		}
		else if (Validator.isBlank(allocateasset.getEmployeeId())){
			errors.put("202","Brand is required");
		}
		else if (Validator.isBlank(allocateasset.getAllocatedDate())){
			errors.put("203","Ip is required");
		}
		else if (Validator.isBlank(allocateasset.getAllocatedTo())){
			errors.put("203","Ip is required");
		}
		else if (Validator.isBlank(allocateasset.getCreatedDate())){
			errors.put("203","Ip is required");
		}
		/*else if (Validator.isBlank(allocateasset.getKeyboardId())){
			errors.put("203","Ip is required");
		}
		else if (Validator.isBlank(allocateasset.getMonitorId())){
			errors.put("203","Ip is required");
		}
		else if (Validator.isBlank(allocateasset.getMouseId())){
			errors.put("203","Ip is required");
		}
		else if (Validator.isBlank(allocateasset.getUpdationDate())){
			errors.put("203","Ip is required");
		}*/
		
		return errors;
	}



}
