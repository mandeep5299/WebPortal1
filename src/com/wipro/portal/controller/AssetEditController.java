package com.wipro.portal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.dao.AssetEditDAO;

import com.wipro.portal.domain.Asset;

import com.wipro.portal.util.Parameter;
import com.wipro.portal.util.Validator;


@Controller
@RequestMapping("/assetEdit.htm")
public class AssetEditController extends BaseController {

	private AssetEditDAO asseteditDAO;

	@Autowired
	public void setBookEditDAO(AssetEditDAO asseteditDAO) {
		this.asseteditDAO = asseteditDAO;
	}

	public String doGet(AppService appService) {
		
		return doPost(appService) ;
	}

	public String doPost(AppService appService) {
		_log.info("AssetEdit Controller : doPost Called");
		String ret="AssetEdit";
		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());
		Asset asset=new Asset();
		String action =param.getString("action");
		System.out.println("Action----"+action);
		
		if(action !=null && action.equalsIgnoreCase("openEdit")) {
			
			_log.info("Employee Edit Controller : doGet Called");
			Asset asset1=null;
			asset.setAssetId(param.getString("assetId"));
			//int id = Integer.parseInt(param.getString("id"));
			// entry.setProid(param.getint("proid",0));
			asset1=asseteditDAO.searchAsset(param.getString("id"));
			_log.info("assetedit"+asset1);
			if(asset!=null){
				model.addAttribute("asset", asset1);
			}
			return "AssetEdit";
		}
		else if(action !=null && action.equalsIgnoreCase("editSave")){
			
			asset.setAssetId(param.getString("assetId"));
			asset.setAssetType(param.getString("assetType"));
			asset.setAssetBrand(param.getString("assetBrand"));
			asset.setMacSerialNo(param.getString("macSerialNo"));
			Map<String, String> errors=doValidate(asset);
			
			if(errors.isEmpty()){
				asseteditDAO.updateAsset(asset);
				ret="LoginHomePage";
				return ret;
			}
			model.addAttribute("asset",asset);             
			model.addAttribute("errors",errors);
			return "AssetEdit";
		}
		
		
		return "AssetEdit";
	}
	
	private Map<String, String> doValidate(Asset asset) {
		Map<String, String> errors1= new HashMap<String, String>();

		if (Validator.isBlank(asset.getAssetId())) {
			errors1.put("200", "getAssetId is required");
		}
		else if(Validator.isBlank(asset.getAssetType())) {
			errors1.put("201", "getAssetType  required");
		}
		else if (Validator.isBlank(asset.getAssetBrand())){
			errors1.put("202","getAssetBrand required");
		}
		else if(Validator.isBlank(asset.getMacSerialNo())){
			errors1.put("501","getMacSerialNo required");
		}
		return errors1;

	}
}

