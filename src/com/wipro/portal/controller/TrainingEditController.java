package com.wipro.portal.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wipro.portal.dao.TrainingEditDAO;
import com.wipro.portal.domain.Training;
import com.wipro.portal.util.Parameter;
import com.wipro.portal.util.Validator;

@Controller
@RequestMapping("/trainingEdit.htm")
public class TrainingEditController extends BaseController {

	TrainingEditDAO trainingeditDAO;

	@Autowired
	public void setTrainingEditDAO(TrainingEditDAO trainingeditDAO) {
		this.trainingeditDAO = trainingeditDAO;
	}
	
	public String doGet(AppService appService) {
		_log.info("ENTERY:");
		return doPost(appService);
	}
	
	public String doPost(AppService appService) {
		_log.info("Product List Controller : doPost Called");
		Training training = null;
		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());
		String action = param.getString("action");
		System.out.println("Action----"+action);

		if(action !=null && action.equalsIgnoreCase("openEdit")) {
			if(param.getString("id") != null && !param.getString("id").equals("") ) {
			  training = (Training) trainingeditDAO.searchTraining(Integer.parseInt(param.getString("id")));
			  
			}
			 
			if(training!=null) {
				model.addAttribute("training", training);
				return "TrainingEdit";
				
			}
		}		
		return "TrainingEdit"; 
    }
}

