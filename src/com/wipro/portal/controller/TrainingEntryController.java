	package com.wipro.portal.controller;


import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.portal.controller.AppService;
import com.wipro.portal.domain.MultiPartFileUploadBean;
import com.wipro.portal.domain.Training;

import com.wipro.portal.dao.TrainingEntryDAO;
import com.wipro.portal.util.Parameter;
import com.wipro.portal.util.Validator;
import java.util.Map;



@Controller

public class TrainingEntryController  { 

	private TrainingEntryDAO trainingentryDAO;


	@Autowired
	public void setTrainingEntryDAO(TrainingEntryDAO trainingentryDAO) {

		this.trainingentryDAO = trainingentryDAO;

	}
	@RequestMapping(value = "/trainingEntry.htm", method = RequestMethod.GET)
	public String doGet(AppService appService) {
		return "TrainingEntry";
	}
	//@RequestMapping(value = "/trainingEntry.htm", method = RequestMethod.POST)
	public String doPost(AppService appService) {

		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());		
		 
		int id;
		if(param.getString("employeeId")==""){
			id=0;
		}
		else{
			id=Integer.parseInt(param.getString("employeeId"));
		}
		long contact;
		if(param.getString("contactNumber")==""){
			contact=0;
		}
		else{
			contact=Long.parseLong(param.getString("contactNumber"));
		}
		Training training=new Training();
		
		training.setEmployeeId(id); 

		training.setTrainingname(param.getString("trainingname"));

		training.setTrainingdescription(param.getString("trainingdescription"));

		training.setPrerequistics(param.getString("prerequistics"));

		training.setDate(param.getString("date"));
		
		training.setTime(param.getString("time"));
		
		training.setVenue(param.getString("venue"));
		
		training.setContactperson(contact);
	
		Map<String, String> errors = doValidate(training);

		if (errors.isEmpty()) {
			trainingentryDAO.saveTraining(training);
			return "Success";
		}

		model.addAttribute("training", training);
		model.addAttribute("errors",errors);
		return "TrainingEntry";

	}
	
	private Map<String, String> doValidate(Training training) {
		HashMap<String, String> errors = new HashMap<String, String>();

		if (Validator.isBlank(training.getEmployeeId())) {
			errors.put("300", "Training ID is required");
		}
		else if (Validator.isBlank(training.getTrainingname())) {
			errors.put("301", "Training Name is required");
		}
		else if (Validator.isBlank(training.getTrainingdescription())){
			errors.put("302","Training Description is required");
		}
		else if (Validator.isBlank(training.getPrerequistics())){
			errors.put("303","Pre Requistics is required");
		}
		else if (Validator.isBlank(training.getDate())){
			errors.put("304","Date is required");
		}
		else if (Validator.isBlank(training.getTime())){
			errors.put("305","Time is required");
		}
		else if (Validator.isBlank(training.getVenue())){
			errors.put("306","Venue is required");
		}
		else if (Validator.isBlank(training.getContactperson())){
			errors.put("307","Contact Person is required");
		}

		return errors;
	}



}
