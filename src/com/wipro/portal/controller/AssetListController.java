
package com.wipro.portal.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



import com.wipro.portal.dao.AssetListDAO;
import com.wipro.portal.domain.Asset;
import com.wipro.portal.util.Parameter;
import com.wipro.portal.util.Validator;

@Controller
@RequestMapping("/assetList.htm")

public class AssetListController extends BaseController {
	private AssetListDAO assetlistDAO;

	@Autowired

	public void setAssetListDAO(AssetListDAO assetlistDAO) {
	this.assetlistDAO = assetlistDAO;
	_log.info("Hello");
	}

	public String doGet(AppService appService) {
		
		return doPost(appService);

	}
	public String doPost(AppService appService) {
		_log.info("Asset List Controller : doPost Called");

		List<Asset> assets=null;
		ModelMap model = appService.getModelMap();
		HttpSession session=appService.getRequest().getSession();
		Asset asset=new Asset();
		assets=assetlistDAO.ListAsset();
		model.addAttribute("asset", assets);
		return "AssetList";
	}

	private Map<String, String> doValidate(Asset asset) {
		HashMap<String, String> errors = new HashMap<String, String>();

		if (Validator.isBlank(asset.getAssetBrand())) {
			errors.put("200", "Enter Asset name.");
		}
		else if(Validator.isBlank(asset.getAssetId())) {
            errors.put("201", "OOPS No Record Found.");
        }
		else if(Validator.isBlank(asset.getAssetBrand())) {
            errors.put("202", "OOPS No Record Found.");
        }
		else if(Validator.isBlank(asset.getMacSerialNo())) {
            errors.put("203", "OOPS No Record Found.");
        }

		 
		return errors;
	}


}
