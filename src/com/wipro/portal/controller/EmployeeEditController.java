package com.wipro.portal.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wipro.portal.dao.EmployeeEditDAO;
import com.wipro.portal.domain.Employee;
import com.wipro.portal.util.Parameter;

@Controller
@RequestMapping("/employeeEdit.htm")
public class EmployeeEditController extends BaseController {

	private EmployeeEditDAO employeeeditDAO;

	@Autowired
	public void setBookEditDAO(EmployeeEditDAO employeeeditDAO) {
		this.employeeeditDAO = employeeeditDAO;
	}

	public String doGet(AppService appService) {
		return doPost(appService) ;
		
	}

	public String doPost(AppService appService) {
		_log.info("Product List Controller : doPost Called");
		
		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());
		String action =param.getString("action");
		System.out.println("Action----"+action);
		if(action !=null && action.equalsIgnoreCase("openEdit")) {

			_log.info("Employee Edit Controller : doGet Called");
			int id =  Integer.parseInt(param.getString("id"));
			Employee employee = (Employee) employeeeditDAO.searchEmployee(id);

			_log.info("employeeedit"+employee);

			if(employee!=null){
				model.addAttribute("employee", employee);
			}

			return "EmployeeEdit";

		} else 	if(action !=null && action.equalsIgnoreCase("editSave")) {

			Map<String, String> errors =null;
			Employee employee=new Employee();
			_log.info("ID: "+param.getString("id"));
			employee.setEmployeeID(Integer.parseInt(param.getString("id")));
			employee.setName(param.getString("name"));
			employee.setBusinessUnit(param.getString("businessunit"));
			employee.setStatus(param.getString("status"));
			employee.setContactNo(Long.parseLong(param.getString("contact")));
			employee.setAimMailID(param.getString("aimid"));
			employee.setWiproMailID(param.getString("wiproid"));
			employee.setAimChatID(param.getString("aimchatid"));
			employee.setAppleMailID(param.getString("appleid"));
			
			errors =doValidate(employee);
			System.out.println("Errors: "+ errors.toString());

			if(errors.isEmpty()){
				employeeeditDAO.updateEmployee(employee);
				return "LoginHomePage";

			}
			model.addAttribute("employee",employee);             
			model.addAttribute("errors",errors);

			return "EmployeeEdit"; 
		}

		return "EmployeeEdit"; 
}
	private Map<String, String> doValidate(Employee employee) {
		Map<String, String> errors1= new HashMap<String, String>();

	/*	if (Validator.isBlank(book.getBookAuthor())) {
			errors1.put("200", "bookAuthor is required");
		}
		else if(Validator.isBlank(book.getBookName())) {
			errors1.put("201", "bookAuthor and bookName required");
		}
		else if (Validator.isBlank(book.getBookPublisher())){
			errors1.put("202","bookAuthor,bookName and bookPublisher required");
		}
		else if(Validator.isBlank(book.getBookPrice())){
			errors1.put("501","bookAuthor,bookName, bookPublisher n bookPrice required");
		}
		else if(Validator.isBlank(book.getBookCertificate())){
			errors1.put("502","bookAuthor,bookName, bookPublisher , bookPrice n bookCertificate required");
		}
		else if(Validator.isBlank(book.getBookRating())){
			errors1.put("503","bookAuthor,bookName, bookPublisher , bookPrice n bookCertificate bookRating required");
		}*/

		return errors1;

	}
}

