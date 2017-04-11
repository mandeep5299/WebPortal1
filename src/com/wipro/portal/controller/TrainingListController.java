
package com.wipro.portal.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.portal.dao.AssetListDAO;
import com.wipro.portal.dao.TrainingListDAO;
import com.wipro.portal.domain.Asset;
import com.wipro.portal.domain.Training;
import com.wipro.portal.exception.ServiceException;
import com.wipro.portal.util.Validator;

@Controller
@RequestMapping("/TrainingList.htm")
public class TrainingListController extends BaseController {
	
	TrainingListDAO traininglistDAO;

	@Autowired
	public void setTrainingListDAO(TrainingListDAO traininglistDAO) {
		this.traininglistDAO = traininglistDAO;
	}

	@Override
	public String doGet(AppService appService) throws ServiceException {
		return doPost(appService);		
	}
	

	@Override
	public String doPost(AppService appService) throws ServiceException {
		_log.info("TrainingList Controller : doGet Called");
		List<Training> trainings=null;


		ModelMap model = appService.getModelMap();
		
		trainings=traininglistDAO.ListTraining();

		model.addAttribute("training", trainings);
		return "TrainingList";  
	}

}

