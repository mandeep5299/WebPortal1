
package com.wipro.portal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.util.Parameter;
import com.wipro.portal.util.Validator;
import com.wipro.portal.dao.LoginDAO;
import com.wipro.portal.domain.Login;


import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login.htm")
public class LoginController extends BaseController {

	LoginDAO loginDAO;

	@Autowired
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public String doGet(AppService appService) {
		_log.info("Login controller : doGet Called");

		HttpSession sesion=appService.getRequest().getSession();

		if(sesion.getAttribute("LoggedIn")!=null){
			return "LoginHomePage";
		}else{        
			return "Login";
		}

	}

	public String doPost(AppService appService) {
		_log.info("PLogin  Controller : doPost Called");
		String returnpage="LoginHomePage";

		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());
		HttpSession sesion=appService.getRequest().getSession();

		String uname=param.getString("uname");
		Login login=new Login();
		login.setUname(uname);
		String password=param.getString("password");
		login.setPassword(password);

		_log.info("uname:"+uname);

		Map errors = doValidate(uname,password);

		_log.info("===>"+errors.isEmpty());

		if (errors.isEmpty()) {

			_log.info("===>"+loginDAO);
			_log.info("===>"+loginDAO.validateUser(login));

			if(loginDAO.validateUser(login)){

				sesion.setAttribute("LoggedIn",login.getUname());

				returnpage="LoginHomePage";

			}else{
				errors.put("203", "User name or password incorrect. please check and try again...");
			}

		}

		if (!errors.isEmpty()) {
			model.addAttribute("errors", errors);
		}

		return returnpage;

	}

	private Map doValidate(String uname,String password) {
		Map<String, String> errors = new HashMap<String, String>();

		if (Validator.isBlank(uname)) {
			errors.put("001", "User Name is required");
		}
		else if(Validator.isBlank(password)) {
			errors.put("002", "Password is required");
		}


		return errors;
	}

}
