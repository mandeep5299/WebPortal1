package com.wipro.portal.controller;

import java.io.ByteArrayOutputStream;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.portal.dao.SearchTrainingDAO;
import com.wipro.portal.domain.Training;
import com.wipro.portal.exception.ServiceException;
import com.wipro.portal.util.Parameter;

@Controller
@RequestMapping("/SearchTraining.htm")
public class SearchTrainingController extends BaseController {
	private SearchTrainingDAO searchTrainingDAO;

	@Autowired
	public void setEmployeeListDAO(SearchTrainingDAO searchTrainingDAO) {
		this.searchTrainingDAO = searchTrainingDAO;
	}

	public String doGet(AppService appService) {
		return "SearchTraining";
	}

	@Override
	public String doPost(AppService appService) throws ServiceException {
		
		
		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());
		HttpSession sesion = appService.getRequest().getSession();
		
		List<Training> trainingList = null;
		Training training = new Training();
		FileSystemView filesys = FileSystemView.getFileSystemView();

		String buttonName=param.getString("SUBMIT");

		if (buttonName.equals("SEARCH TRAINING")) {
			int id = 0;
			if (param.getString("employeeId") == "") {
				id = 0;
			} else {
				id = Integer.parseInt(param.getString("employeeId"));
			}
						
			training.setEmployeeId(id);
			training.setTrainingname(param.getString("trainingname"));
			training.setDate(param.getString("date"));
			training.setTime(param.getString("time"));
			training.setVenue(param.getString("venue"));
			

			sesion.setAttribute("EmployeeId", id);
			sesion.setAttribute("TrainingName", training.getTrainingname());
			sesion.setAttribute("Date", training.getDate());
			sesion.setAttribute("Time", training.getTime());
			sesion.setAttribute("Venue", training.getVenue());

			trainingList = searchTrainingDAO.SearchTraining(sesion);
			_log.info("RECORD: "+trainingList.size());
			model.addAttribute("training", trainingList);
			
			
		}else if(buttonName.equals("Import As PDF")){			 
			_log.info("Import as pdf="+sesion.getAttribute("TrainingName"));
			try {
				trainingList = searchTrainingDAO.SearchTraining(sesion);
				
				InputStream inputStream = new ClassPathResource("jrxml/TrainingJasperReport.jrxml").getInputStream();

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						trainingList);

				Map<String, Object> parameterMap = new HashMap<String, Object>();
				JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
				_log.info("Column Count: " + jasperDesign.getColumnCount());
				JasperReport jasperReport = JasperCompileManager
						.compileReport(jasperDesign);
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						jasperReport, parameterMap, beanColDataSource);
				JasperExportManager.exportReportToPdfFile(jasperPrint,
						filesys.getHomeDirectory()+"/Desktop/TrainingReport.pdf");
				inputStream.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(buttonName.equals("Import As XLS")){
			_log.info("Import as XLS");

			try {
				trainingList = searchTrainingDAO.SearchTraining(sesion);
				
				InputStream inputStream = new ClassPathResource("jrxml/TrainingJasperReport.jrxml").getInputStream();
		
				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						trainingList);
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
				_log.info("Column Count: " + jasperDesign.getColumnCount());
				JasperReport jasperReport = JasperCompileManager
						.compileReport(jasperDesign);
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						jasperReport, parameterMap, beanColDataSource);
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				OutputStream outputfile = new FileOutputStream(filesys.getHomeDirectory()+"/Desktop/TrainingReport.xls");

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
		return "GenerateTrainingReport";	
	}
}