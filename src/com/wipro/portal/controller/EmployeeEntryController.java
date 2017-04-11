package com.wipro.portal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.wipro.portal.controller.BaseController;
import com.wipro.portal.domain.Employee;
import com.wipro.portal.domain.EmployeeVisa;
import com.wipro.portal.domain.Visa;
import com.wipro.portal.util.Validator;
import com.wipro.portal.dao.EmployeeEntryDAO;
import com.wipro.portal.util.Parameter;



@Controller
@RequestMapping("/employeeEntry.htm")

public class EmployeeEntryController  extends BaseController {
	private EmployeeEntryDAO addEmployeeDAO;
	
	@Autowired
	public void setAddEmployeeDAO(EmployeeEntryDAO addEmployeeDAO) {
		this.addEmployeeDAO = addEmployeeDAO;
	}



	public String doGet(AppService appService) {
		return "EmployeeEntry";
	}

	public String doPost(AppService appService) {
		String returnpage="EmployeeEntry";

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
				
		//setter for employee domain
		Employee employee=new Employee();
		employee.setEmployeeID(id);
		employee.setName(param.getString("employeeName"));
		employee.setStatus(param.getString("status"));
		employee.setContactNo(contact);
		employee.setBusinessUnit(param.getString("businessUnit"));
		employee.setAimMailID(param.getString("aimId"));
		employee.setWiproMailID(param.getString("wiproId"));
		employee.setAimChatID(param.getString("aimChatId"));
		employee.setAppleMailID(param.getString("appleId"));
				
		addEmployeeDAO.saveEmployee(employee);
		
		return returnpage;
	}
}