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

import com.wipro.portal.dao.SearchAssetDAO;
import com.wipro.portal.domain.Asset;
import com.wipro.portal.exception.ServiceException;
import com.wipro.portal.util.Parameter;

@Controller
@RequestMapping("/SearchAsset.htm")
public class SearchAssetController extends BaseController {
	private SearchAssetDAO searchAssetDAO;

	@Autowired
	public void setEmployeeListDAO(SearchAssetDAO searchAssetDAO) {
		this.searchAssetDAO = searchAssetDAO;
		_log.info("Hello");
	}

	public String doGet(AppService appService) {
		return "SearchAsset";
	}

	@Override
	public String doPost(AppService appService) throws ServiceException {
		
		
		ModelMap model = appService.getModelMap();
		Parameter param = new Parameter(appService.getRequest());
		
		HttpSession sesion = appService.getRequest().getSession();
		List<Asset> assetList = null;
		Asset assets = new Asset();
		
		FileSystemView filesys = FileSystemView.getFileSystemView();
		String buttonName=param.getString("SUBMIT");

		_log.info("BUTTON NAME: "+buttonName);
		
		if (buttonName.equals("SEARCH ASSET")) {
				
			assets.setAssetId((param.getString("assetId")));
			assets.setAssetType((param.getString("assetName")));
			assets.setAssetBrand((param.getString("brandName")));
		

			sesion.setAttribute("assetId", assets.getAssetId());
			sesion.setAttribute("assetName", assets.getAssetType());
			sesion.setAttribute("brandName", assets.getAssetBrand());

			assetList = searchAssetDAO.SearchAsset(sesion);
			_log.info("RECORD: "+assetList.size());
			if (assetList.size() == 0) {
				return "Error";
			}
			model.addAttribute("asset", assetList);
						
		}else if(buttonName.equals("Import As PDF")){			 
			_log.info("Import as pdf="+sesion.getAttribute("EmployeeName"));
			try {
				assetList = searchAssetDAO.SearchAsset(sesion);
				
				InputStream inputStream = new ClassPathResource("jrxml/AssetJasperReport.jrxml").getInputStream();

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						assetList);

				Map<String, Object> parameterMap = new HashMap<String, Object>();
				JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
				_log.info("Column Count: " + jasperDesign.getColumnCount());
				JasperReport jasperReport = JasperCompileManager
						.compileReport(jasperDesign);
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						jasperReport, parameterMap, beanColDataSource);
				JasperExportManager.exportReportToPdfFile(jasperPrint,
						filesys.getHomeDirectory()+"/Desktop/AssetReport.pdf");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(buttonName.equals("Import As XLS")){
			_log.info("Import as XLS");

			try {
				assetList = searchAssetDAO.SearchAsset(sesion);

				InputStream inputStream = new ClassPathResource("jrxml/AssetJasperReport.jrxml").getInputStream();
		
				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						assetList);
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
				_log.info("Column Count: " + jasperDesign.getColumnCount());
				JasperReport jasperReport = JasperCompileManager
						.compileReport(jasperDesign);
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						jasperReport, parameterMap, beanColDataSource);
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				OutputStream outputfile = new FileOutputStream(filesys.getHomeDirectory()+"/Desktop/AssetReport.pdf");

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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "GenerateAssetReport";	
	}
}