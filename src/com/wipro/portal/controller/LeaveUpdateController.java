package com.wipro.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.exception.ServiceException;

	
	@Controller
	@RequestMapping("/leaveUpdate.htm")
	public class LeaveUpdateController extends BaseController {

	@Override
	public String doGet(AppService appService) throws ServiceException {
		System.out.println("  Get leaveUpdate ");
		return "leaveUpdate";
	}

	@Override
	public String doPost(AppService appService) throws ServiceException {
		System.out.println("LeaveUpdateController.doPost()");
		
		String[] fullDayArray = appService.getRequest().getParameterValues("fullDay");
		String[] hDayArray = appService.getRequest().getParameterValues("halfDay");
		
		if (fullDayArray != null) {
		      for (int p = 0; p < fullDayArray.length; p++) {
		    	  String fullDay = fullDayArray[p];
		    	  System.out.println("LeaveUpdateController.doPost()   Full day -- > "+fullDay);
		    	  
		      }
		   }
		 if (hDayArray != null) {
	      for (int p = 0; p < hDayArray.length; p++) {
	    	  String hDay = hDayArray[p];
	    	  System.out.println("LeaveUpdateController.doPost()   half day -- > "+hDay);
	    	  
	      }
	   }
	
	return "leaveUpdate";
} 
}
