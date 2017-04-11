package com.wipro.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.dao.AssetAllocateDAO;
import com.wipro.portal.dao.AssetListDAO;
import com.wipro.portal.domain.AllocateAsset;
import com.wipro.portal.exception.ServiceException;
import com.wipro.portal.util.Parameter;

@Controller
@RequestMapping("/AllocateAssetModify.htm")
public class AssetAllocateModifyController extends BaseController {

	private AssetAllocateDAO assetallocateDAO;
	private AssetListDAO assetlistDAO;
	
	@Autowired
	public void setAssetlistDAO(AssetListDAO assetlistDAO) {
		this.assetlistDAO = assetlistDAO;
	}

	@Autowired
	public void setAssetallocateDAO(AssetAllocateDAO assetallocateDAO) {
		this.assetallocateDAO = assetallocateDAO;
	}

	@Override
	public String doGet(AppService appService) throws ServiceException {
		
	  	return doPost(appService);
	}

	@Override
	public String doPost(AppService appService) throws ServiceException {
		// TODO Auto-generated method stub
		AllocateAsset allocatedAsset = new AllocateAsset();
		Parameter param = new Parameter(appService.getRequest());
		ModelMap model = appService.getModelMap();
		
		
		List freeCPUList = assetlistDAO.findFreeAssetListByassetType("CPU");
		List freeKeyboardList = assetlistDAO.findFreeAssetListByassetType("KEYBOARD");
		List freeMonitorList = assetlistDAO.findFreeAssetListByassetType("MONITOR");
		List freeMouseList = assetlistDAO.findFreeAssetListByassetType("MOUSE");
	 
			
		
		String search = param.getString("searchEmployeeId");
		System.out.println("employee id : "+ search);
		if(search!=null && !search.equals("")){
			allocatedAsset = assetallocateDAO.searchAllocatedAssetData(search.trim());
		}
		
		freeCPUList.add(allocatedAsset.getCpuId());
		freeKeyboardList.add(allocatedAsset.getKeyboardId());
		freeMonitorList.add(allocatedAsset.getMonitorId());
		freeMouseList.add(allocatedAsset.getMouseId());
		
		System.out.println("searchEmployeeId--------"+ search);
		System.out.println(allocatedAsset.getAllocatedBy());
		System.out.println(allocatedAsset.getAllocatedDate());
		System.out.println(allocatedAsset.getAllocatedTo());
		System.out.println(allocatedAsset.getCpuId());
		System.out.println(allocatedAsset.getCreatedDate());
		System.out.println(allocatedAsset.getKeyboardId());
		System.out.println(allocatedAsset.getMonitorId());
		System.out.println(allocatedAsset.getMouseId());
		
		model.addAttribute("freeCPUList", freeCPUList);
		model.addAttribute("freeKeyboardList", freeKeyboardList);
		model.addAttribute("freeMonitorList", freeMonitorList);
		model.addAttribute("allocatedAsset", allocatedAsset);
		model.addAttribute("freeMouseList", freeMouseList);
		
		model.addAttribute("allocatedCPU", allocatedAsset.getCpuId());
		model.addAttribute("allocatedKeyboard", allocatedAsset.getKeyboardId());
		model.addAttribute("allocatedMonitor", allocatedAsset.getMonitorId());
		model.addAttribute("allocatedMouse", allocatedAsset.getMouseId());
		
		
		
		return "AllocateAssetModify";
	}

}
