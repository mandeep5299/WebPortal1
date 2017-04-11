package com.wipro.portal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.dao.EmployeeListDAO;
import com.wipro.portal.domain.Employee;
import com.wipro.portal.util.Validator;

@Controller
@RequestMapping("/employeeList.htm")
public class EmployeeListController extends BaseController {
	private EmployeeListDAO employeelistDAO;

	@Autowired
	public void setEmployeeListDAO(EmployeeListDAO employeelistDAO) {
		this.employeelistDAO = employeelistDAO;
		_log.info("Hello");
	}

	public String doGet(AppService appService) {
		_log.info("EmployeeList Controller : doGet Called");
		List<Employee> employees = null;

		ModelMap model = appService.getModelMap();

		HttpSession session = appService.getRequest().getSession();
		Employee employee = new Employee();
		
		employees = employeelistDAO.ListEmployee();

		model.addAttribute("employee", employees);
		return "EmployeeList";

	}

	public String doPost(AppService appService) {
		_log.info("Employee List Controller : doPost Called");

		List<Employee> employees = null;

		ModelMap model = appService.getModelMap();

		Employee employee = new Employee();

		employees = employeelistDAO.ListEmployee();

		_log.info("isemptyyyyyyyyy!!!!!" + employees);

		model.addAttribute("employee", employees);
		return "EmployeeList";
	}

	private Map<String, String> doValidate(Employee employee) {
		HashMap<String, String> errors = new HashMap<String, String>();

		if (Validator.isBlank(employee.getEmployeeID())) {
			errors.put("100", "Enter Employee ID.");
		} else if (Validator.isBlank(employee.getName())) {
			errors.put("101", "Enter Employee Name.");
		} else if (Validator.isBlank(employee.getBusinessUnit())) {
			errors.put("102", "Enter Business Unit.");
		} else if (Validator.isBlank(employee.getStatus())) {
			errors.put("103", "Enter Employee Status.");
		} else if (Validator.isBlank(employee.getContactNo())) {
			errors.put("103", "Enter Contact Number.");
		} else if (Validator.isBlank(employee.getAimMailID())) {
			errors.put("103", "Enter AIM Mail ID.");
		} else if (Validator.isBlank(employee.getWiproMailID())) {
			errors.put("103", "Enter Wipro Mail ID.");
		} else if (Validator.isBlank(employee.getAimChatID())) {
			errors.put("103", "Enter AIM Chat ID.");
		} else if (Validator.isBlank(employee.getAppleMailID())) {
			errors.put("103", "Enter Apple Mail ID.");
		}

		return errors;
	}
}