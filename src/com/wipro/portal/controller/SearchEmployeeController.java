package com.wipro.portal.controller;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.dao.EmployeeListDAO;
import com.wipro.portal.dao.SearchEmployeeDAO;
import com.wipro.portal.domain.Employee;
import com.wipro.portal.exception.ServiceException;
import com.wipro.portal.util.Parameter;
import com.wipro.portal.util.Validator;

@Controller
@RequestMapping("/SearchEmployee.htm")
public class SearchEmployeeController extends BaseController {
	private SearchEmployeeDAO searchEmployeeDAO;

	@Autowired
	public void setEmployeeListDAO(SearchEmployeeDAO searchEmployeeDAO) {
		this.searchEmployeeDAO = searchEmployeeDAO;
		_log.info("Hello");
	}

	public String doGet(AppService appService) {
		return "SearchEmployee";
	}

	@Override
	public String doPost(AppService appService) throws ServiceException {
		
		
		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());
		HttpSession sesion = appService.getRequest().getSession();
		
		List<Employee> employees = null;
		Employee employee = new Employee();
		FileSystemView filesys = FileSystemView.getFileSystemView();

		String buttonName=param.getString("SUBMIT");

		if (buttonName.equals("SEARCH EMPLOYEE")) {
			int id = 0;
			if (param.getString("employeeId") == "") {
				id = 0;
			} else {
				id = Integer.parseInt(param.getString("employeeId"));
			}
			
			long contactNo = 0;
			if (param.getString("contactNumber") == "") {
				contactNo = 0;
			} else {
				contactNo =  Long.parseLong(param.getString("contactNumber"));
			}
			
			employee.setEmployeeID(id);
			employee.setContactNo(contactNo);
			employee.setName(param.getString("employeeName"));
			employee.setBusinessUnit(param.getString("businessUnit"));
			employee.setAimMailID(param.getString("aimId"));
			employee.setWiproMailID(param.getString("wiproId"));
			employee.setAppleMailID(param.getString("appleId"));

			sesion.setAttribute("EmployeeID", id);
			sesion.setAttribute("EmployeeName", employee.getName());
			sesion.setAttribute("BussinessUnit", employee.getBusinessUnit());
			sesion.setAttribute("ContactNumber", employee.getContactNo());
			sesion.setAttribute("AimID", employee.getAimMailID());
			sesion.setAttribute("WiproID", employee.getWiproMailID());
			sesion.setAttribute("AppleID", employee.getAppleMailID());

			employees = searchEmployeeDAO.SearchEmployee(sesion);
			_log.info("RECORD: "+employees.size());
			model.addAttribute("employee", employees);
			
			
		}else if(buttonName.equals("Import As PDF")){			 
			_log.info("Import as pdf="+sesion.getAttribute("EmployeeName"));
			try {
				employees = searchEmployeeDAO.SearchEmployee(sesion);
				
				InputStream inputStream = new ClassPathResource("jrxml/EmployeeJasperReport.jrxml").getInputStream();

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						employees);

				Map<String, Object> parameterMap = new HashMap<String, Object>();
				JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
				_log.info("Column Count: " + jasperDesign.getColumnCount());
				JasperReport jasperReport = JasperCompileManager
						.compileReport(jasperDesign);
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						jasperReport, parameterMap, beanColDataSource);
				JasperExportManager.exportReportToPdfFile(jasperPrint,
						filesys.getHomeDirectory()+"/Desktop/EmployeeReport.pdf");
				inputStream.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(buttonName.equals("Import As XLS")){
			_log.info("Import as XLS");

			try {
				employees = searchEmployeeDAO.SearchEmployee(sesion);
				
				InputStream inputStream = new ClassPathResource("jrxml/EmployeeJasperReport.jrxml").getInputStream();
		
				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						employees);
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
				_log.info("Column Count: " + jasperDesign.getColumnCount());
				JasperReport jasperReport = JasperCompileManager
						.compileReport(jasperDesign);
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						jasperReport, parameterMap, beanColDataSource);
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				OutputStream outputfile = new FileOutputStream(filesys.getHomeDirectory()+"/Desktop/EmployeeReport.xls");

				// coding For Excel:
				JRXlsExporter exporterXLS = new JRXlsExporter();
				exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,
						jasperPrint);
				exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
						output);
				exporterXLS.setParameter(
						JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
						Boolean.TRUE);
				exporterXLS.setParameter(
						JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
						Boolean.TRUE);
				exporterXLS.setParameter(
						JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
						Boolean.FALSE);
				exporterXLS
						.setParameter(
								JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
								Boolean.TRUE);
				exporterXLS.exportReport();
				outputfile.write(output.toByteArray());
				inputStream.close();
				outputfile.close();
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "GenerateEmployeeReport";	
	}
}