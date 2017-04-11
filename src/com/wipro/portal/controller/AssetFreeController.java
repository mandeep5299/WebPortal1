package com.wipro.portal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.dao.AssetListDAO;
import com.wipro.portal.domain.Asset;
import com.wipro.portal.exception.ServiceException;

@Controller
@RequestMapping("/AssetFreeList.htm")

public class AssetFreeController extends BaseController {

	private AssetListDAO assetlistDAO;

	@Autowired
	public void setAssetlistDAO(AssetListDAO assetlistDAO) {
		this.assetlistDAO = assetlistDAO;
	}

	@Override
	public String doGet(AppService appService) throws ServiceException {
		// TODO Auto-generated method stub
		return doPost(appService);
	}

	@Override
	public String doPost(AppService appService) throws ServiceException {
		// TODO Auto-generated method stub
		
		List<Asset> assets=null;
		ModelMap model = appService.getModelMap();
		HttpSession session=appService.getRequest().getSession();
		Asset asset=new Asset();
		assets=assetlistDAO.ListAllocatedAssetsToFree();
		model.addAttribute("asset", assets);
		return "AssetFreeList";
	}

}
