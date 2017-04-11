
package com.wipro.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.portal.exception.ServiceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

@Controller
public abstract class BaseController {

	public static final Logger _log = Logger.getLogger(BaseController.class.getName());

	@RequestMapping(method=RequestMethod.GET)
	public String getMethod(ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		String jspPage = "";
		try {

			jspPage = doGet(getAppService(modelMap, request, response));
			_log.info("Testing");

			HttpSession sesion=request.getSession();

			if(sesion.getAttribute("LoggedIn")==null){
				jspPage="Login";
			}

		}
		catch(ServiceException ex) {
			_log.log(Level.SEVERE, "Error Occured", ex);
			jspPage = "error";
		}
		return jspPage;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String postMethod(ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		String jspPage = "";
		try {

			HttpSession sesion=request.getSession();



			jspPage = doPost(getAppService(modelMap, request, response));
			_log.info("Testing"+jspPage);

			if(sesion.getAttribute("LoggedIn")==null){
				return "Login";
			}   


		}
		catch(ServiceException ex) {
			_log.log(Level.SEVERE, "Error Occured", ex);
			jspPage = "error";
		}
		return jspPage;
	}

	private AppService getAppService(ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {

		AppService appService = new AppService();
		appService.setDesignCenter("1");
		appService.setModelMap(modelMap);
		appService.setRequest(request);
		appService.setResponse(response);

		return appService;
	}

	public abstract String doGet(AppService appService) throws ServiceException;
	public abstract String doPost(AppService appService) throws ServiceException;
}
