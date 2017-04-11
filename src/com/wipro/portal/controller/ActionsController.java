package com.wipro.portal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.portal.dao.AssetAllocateDAO;
import com.wipro.portal.dao.AssetEditDAO;
import com.wipro.portal.dao.AssetListDAO;
import com.wipro.portal.dao.EmployeeEditDAO;
import com.wipro.portal.dao.EmployeeListDAO;
import com.wipro.portal.dao.TrainingEditDAO;
import com.wipro.portal.dao.TrainingListDAO;
import com.wipro.portal.domain.AllocateAsset;
import com.wipro.portal.domain.Asset;
import com.wipro.portal.domain.Employee;
import com.wipro.portal.domain.Training;

@Controller
public class ActionsController {
	
	private TrainingEditDAO trainingEditDAO;
	private TrainingListDAO traininglistDAO ;
	private AssetEditDAO asseteditDAO;
	private AssetListDAO assetlistDAO;
	private EmployeeListDAO employeelistDAO;
	private EmployeeEditDAO employeeeditDAO;
	private AssetAllocateDAO assetAllocateDAO;
	
	
	@Autowired
	public void setEmployeelistDAO(EmployeeListDAO employeelistDAO) {
		this.employeelistDAO = employeelistDAO;
	}

	@Autowired
	public void setEmployeeeditDAO(EmployeeEditDAO employeeeditDAO) {
		this.employeeeditDAO = employeeeditDAO;
	}

	@Autowired
	public void setTraininglistDAO(TrainingListDAO traininglistDAO) {
		this.traininglistDAO = traininglistDAO;
	}

	@Autowired
	public void setTrainingEditDAO(TrainingEditDAO trainingEditDAO) {
		this.trainingEditDAO = trainingEditDAO;
	}
	
	@Autowired
	public void setAsseteditDAO(AssetEditDAO asseteditDAO) {
		this.asseteditDAO = asseteditDAO;
	}

	@Autowired
	public void setAssetlistDAO(AssetListDAO assetlistDAO) {
		this.assetlistDAO = assetlistDAO;
	}

	@Autowired
	public void setAssetAllocateDAO(AssetAllocateDAO assetAllocateDAO) {
		this.assetAllocateDAO = assetAllocateDAO;
	}

	@RequestMapping("/trainingDelete.htm" )
	public ModelAndView trainingDeleteActionPOST(HttpServletRequest request) {
		System.out.println("Coming here ..!!");
		Map<String, List<Training>> model = new HashMap<String, List<Training>>();
		Boolean training1=null;
		Training training = new Training();
		training.setTrainingId(Integer.parseInt(request.getParameter("id")));
		System.out.println(request.getParameter("id"));
		training1=trainingEditDAO.deleteTraining(training);
		if(training1.equals(false)){
			System.out.println("Unable to delete");
		}
		List<Training> trainings=null;
		trainings = traininglistDAO.ListTraining();
		model.put("training", trainings);
		return new ModelAndView("TrainingList","training",trainings);
	}
	
	@RequestMapping("/assetDelete.htm" )
	public ModelAndView assetDeleteActionPOST(HttpServletRequest request) {
		Map<String, List<Asset>> model = new HashMap<String, List<Asset>>();
		Boolean asset1=null;
		Asset asset = new Asset();
		asset.setAssetId((request.getParameter("id")));
		System.out.println(request.getParameter("id"));
		asset1=asseteditDAO.deleteAsset(asset);
		if(asset1.equals(false)){
			System.out.println("Unable to delete");
		}
		List<Asset> assets=null;
		assets = assetlistDAO.ListAsset();
		model.put("asset", assets);
		return new ModelAndView("AssetList","asset",assets);
	}
	
	@RequestMapping("/employeeDelete.htm" )
	public ModelAndView employeeDeleteActionPOST(HttpServletRequest request) {
		Map<String, List<Employee>> model = new HashMap<String, List<Employee>>();
		Boolean employee1=null;
		Employee employee = new Employee();
		employee.setEmployeeID(Integer.parseInt(request.getParameter("id")));
		System.out.println(request.getParameter("id"));
		employee1=employeeeditDAO.deleteEmployee(employee);
		if(employee1.equals(false)){
			System.out.println("Unable to delete");
		}
		List<Employee> employees=null;
		employees = employeelistDAO.ListEmployee();
		model.put("employee", employees);
		return new ModelAndView("EmployeeList","employee",employees);
	}
	
	@RequestMapping("/assetRelease.htm" )
	public ModelAndView assetReleasePOST(HttpServletRequest request){
		Map<String, List<Asset>> model = new HashMap<String, List<Asset>>();
		Boolean asset1=null;
		Asset asset = new Asset();
		AllocateAsset allocatedAsset = new AllocateAsset();
		String assetId = request.getParameter("id");
		String assetType = request.getParameter("type");
		asset = asseteditDAO.searchAsset(assetId);
		asset.setAssetStatus("Free");
		asseteditDAO.updateAsset(asset);
		
		allocatedAsset = assetAllocateDAO.searchAllocatedAssetData(assetId , assetType);
			
		if(assetType.equalsIgnoreCase("CPU")){
			allocatedAsset.setCpuId("");
		}
		else if(assetType.equalsIgnoreCase("KEYBOARD")){
			allocatedAsset.setKeyboardId("");
		}
		else if(assetType.equalsIgnoreCase("MOUSE")){
			allocatedAsset.setMouseId("");
		}
		else if(assetType.equalsIgnoreCase("MONITOR")){
			allocatedAsset.setMonitorId("");
		}
		
		assetAllocateDAO.updateAllocatedAsset(allocatedAsset);
			
		List<Asset> assets=null;
		assets = assetlistDAO.ListAllocatedAssetsToFree();
		model.put("asset", assets);
		return new ModelAndView("AssetFreeList","asset",assets);
		
	}

	@RequestMapping("/Error404.htm")
	public ModelAndView Error404POST(HttpServletRequest request) {
		return new ModelAndView("Error404");
	}
}


