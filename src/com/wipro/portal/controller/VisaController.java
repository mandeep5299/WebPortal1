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
import com.wipro.portal.domain.Visa;

import com.wipro.portal.dao.VisaDAO;
import com.wipro.portal.util.Parameter;
import com.wipro.portal.util.Validator;
import java.util.Map;



@Controller
@RequestMapping("/visa.htm")
public class VisaController extends BaseController { 

	private VisaDAO visaDAO;


	@Autowired
	public void setVisaDAO(VisaDAO visaDAO) {

		this.visaDAO = visaDAO;

	}

	public String doGet(AppService appService) {
		_log.info("Visa Controller : doGet Called");
		ModelMap model = appService.getModelMap();
		model.addAttribute("Visa", new Visa());
		_log.info("hellloooooo");
		return "Visa";
	}

	public String doPost(AppService appService) {
		_log.info("Visa Controller : doPost Called");

		ModelMap model = appService.getModelMap();

		Parameter param = new Parameter(appService.getRequest());
		HttpSession session=appService.getRequest().getSession();

		Visa visa=new Visa();
		_log.info("good");

		visa.setVisaId(param.getString("visaid"));
		_log.info("visaid"+param.getString("visaid"));

		visa.setVisaType(param.getString("visatype"));
		_log.info("visatype "+param.getString("visatype"));

		visa.setValidFrom(param.getString("validfrom"));
		_log.info("validfrom"+param.getString("validfrom"));

		visa.setValidTo(param.getString("validto"));
		_log.info("validto"+param.getString("validto"));
		
		visa.setCountry(param.getString("country"));
		_log.info("country"+param.getString("country"));




		Map errors = doValidate(visa);

		_log.info("===>"+errors.isEmpty());

		if (errors.isEmpty()) {
			visaDAO.saveVisa(visa);
			_log.info("Empty!!");
			return "Visa";
		}

		model.addAttribute("visa", visa);
		model.addAttribute("errors",errors);
		return "Visa";

	}

	private Map<String, String> doValidate(Visa visa) {
		HashMap<String, String> errors = new HashMap<String, String>();
/*
		if (Validator.isBlank(visa.getVisaid())) {
			errors.put("109", "Visa ID is required");
		}
		else if (Validator.isBlank(visa.getVisatype())){
			errors.put("110","Visa Type is required");
		}
		else if (Validator.isBlank(visa.getValidfrom())){
			errors.put("111","Valid From Date is required");
		}
		else if (Validator.isBlank(visa.getValidto())){
			errors.put("112","Valid To Date is required");
		}
		else if (Validator.isBlank(visa.getCountry())){
			errors.put("113","Country is required");
		}
*/
		return errors;
	}



}
