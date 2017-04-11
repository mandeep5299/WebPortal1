package com.wipro.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.wipro.portal.dao.TrainingEditDAO;
import com.wipro.portal.dao.TrainingEntryDAO;
import com.wipro.portal.dao.TrainingListDAO;
import com.wipro.portal.domain.MultiPartFileUploadBean;
import com.wipro.portal.domain.Training;
import com.wipro.portal.util.Validator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@Controller
public class MultiPartFileUploadController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TrainingEntryDAO trainingentryDAO;
	private TrainingEditDAO trainingeditDAO;
	private TrainingListDAO traininglistDAO;

	@Autowired
	public void setTrainingEntryDAO(TrainingEntryDAO trainingentryDAO) {
		this.trainingentryDAO = trainingentryDAO;
	}

	@Autowired
	public void setBookEditDAO(TrainingEditDAO trainingeditDAO) {
		this.trainingeditDAO = trainingeditDAO;
	}

	@Autowired
	public void setTrainingListDAO(TrainingListDAO traininglistDAO) {
		this.traininglistDAO = traininglistDAO;
	}

	@RequestMapping(value = "/uploadtest.htm", method = RequestMethod.GET)
	public String uploadtestProcessGET() throws IOException {
		System.out.println("  uploadtestProcessGET   ");
		return "TrainingEntry";
	}

	@RequestMapping(value = "/uploadtest.htm", method = RequestMethod.POST)
	public String uploadtestProcess(MultiPartFileUploadBean bean,
			BindingResult bindingResult, Model model) throws IOException {

		Training training = new Training();
		training.setEmployeeId(bean.getEmployeeId());
		training.setTrainingname(bean.getTrainingname());
		training.setDate(bean.getDate());
		training.setContactperson(bean.getContactperson());
		training.setTime(bean.getTime());
		training.setPrerequistics(bean.getPrerequistics());
		training.setTrainingdescription(bean.getTrainingdescription());
		training.setVenue(bean.getVenue());

		System.out.println("*********ID : " + bean.getEmployeeId());
		System.out.println("uploadfiles.html ---- getTrainingname :: "
				+ bean.getTrainingname());
		/*
		 * code for MultiPart file
		 */
		int i=0;
		FileOutputStream outputStream = null;
		String dbfileName = "";
		List<MultipartFile> files = bean.getFiles();
		if (files.size() != 0) {
			for (MultipartFile f : files) {
				i++;
				if (!f.isEmpty()) {
					try {
						String directoryPath = System.getProperty("user.home")
								+ "/TrainingSession/" + bean.getEmployeeId();
						System.out
								.println("*******FilePath : " + directoryPath);
						File dir = new File(directoryPath);
						if (!dir.exists()) {
							dir.mkdirs();
							System.out.println("Directory: " + dir);
						}
						String fileName = directoryPath + "/"
								+ bean.getEmployeeId() + "_"
								+ f.getOriginalFilename();
						File file = new File(fileName);
						if (file.exists()) {

							Object[] options = { "Yes", "No", "Cancel" };
							int n = JOptionPane.showOptionDialog(null,
									"File aready exists.\n"
											+ "Overwrite existing file?",
									"Warning", JOptionPane.YES_NO_OPTION,
									JOptionPane.WARNING_MESSAGE, null, options,
									options[2]);

							if (n == 0) {
								try {
									file.delete();
								} catch (Exception e) {
									JOptionPane
											.showMessageDialog(null,
													"Error deleting file.\nClose the file if it is open.");
									return "TrainingEntry";
								}
							} else {
								return "TrainingEntry";
							}
						}
						System.out.println("********* PATH: " + fileName);
						outputStream = new FileOutputStream(file);
						outputStream.write(f.getBytes());
						outputStream.close();
						dbfileName = bean.getEmployeeId() + "_"+ f.getOriginalFilename();
						System.out.println("APPEND: " + dbfileName);
						if(i==1){
							training.setAttachFile1(dbfileName);
						}
						if(i==2){
							training.setAttachFile2(dbfileName);
						}
						if(i==3){
							training.setAttachFile3(dbfileName);
						}
					} catch (FileNotFoundException e) {
						System.out.println("File not found" + e);
					}
				}
			}
		}

		Map<String, String> errors = doValidate(training);

		if (errors.isEmpty()) {
			trainingentryDAO.saveTraining(training);
			return "Success";
		}
		model.addAttribute("training", training);
		return "TrainingEntry";
	}

	@RequestMapping(value = "/download.htm", method = RequestMethod.GET)
	public String downloadAttachment(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String filename = (String) request.getParameter("filename");
		System.out.println(" filename  -- >  " + filename);

		long startTime = System.currentTimeMillis();
		System.out.println("Connecting to WebPortal site...\n" + startTime);

		BufferedInputStream in = null;
		FileOutputStream fout = null;
		try {
			in = new BufferedInputStream(new URL(
					"http://localhost:8080/WebPortal/").openStream());
			System.out.println("Total Bytes: " + in.available());
			fout = new FileOutputStream(System.getProperty("user.home")
					+ "/DJ.pdf");

			byte data[] = new byte[1024];
			int count;
			while ((count = in.read(data, 0, 1024)) != -1) {
				fout.write(data, 0, count);
			}
		} finally {
			if (in != null)
				in.close();
			if (fout != null)
				fout.close();
		}

		return "TrainingList";
	}

	@RequestMapping(value = "/editTraining.htm", method = RequestMethod.POST)
	public String editTraining(MultiPartFileUploadBean bean,
			BindingResult bindingResult, Model model, HttpServletRequest request)
			throws IOException {
		String action = request.getParameter("action");
		System.out.println("ACTION: " + action.toString());

		if (action != null && action.equalsIgnoreCase("editSave")) {
			String trainingId =  (String) request.getParameter("trainingId");
			Map<String, String> errors = null;
			 
			Training training =  (Training)trainingeditDAO.findByTrainingId(Integer.parseInt(trainingId));
			
			if(!request.getParameter("trainingName").equals(training.getTrainingname())) {
				training.setTrainingname(request.getParameter("trainingName"));
				System.out.println("Edit Name");
			}
			
			if(!request.getParameter("venue").equals(training.getVenue())) {
				training.setVenue(request.getParameter("venue"));
				System.out.println("Edit Venue");
			}
			
			if(!request.getParameter("trainingDescription").equals(training.getTrainingdescription())) {
				training.setTrainingdescription(request.getParameter("trainingDescription"));
				System.out.println("Edit Desc");
			}
			
			if(!request.getParameter("prerequistics").equals(training.getPrerequistics())) {
				training.setPrerequistics(request.getParameter("prerequistics"));
				System.out.println("Edit Pre");
			}
			
			if(!request.getParameter("date").equals(training.getDate())) {
				training.setDate(request.getParameter("date"));
				System.out.println("Edit DAte");
			}
			
			if(!request.getParameter("time").equals(training.getTime())) {
				training.setTime(request.getParameter("time"));
				System.out.println("Edit Time");
			}
			
			if(!(Long.parseLong(request.getParameter("contactNumber"))==training.getContactperson())) {
				training.setContactperson(Long.parseLong(request.getParameter("contactNumber")));
				System.out.println("Edit Contact");
			}
			
			/*int i=0;
			FileOutputStream outputStream = null;
			String dbfileName = "";
			List<MultipartFile> files = bean.getFiles();

			if (files.size() != 0) {
				for (MultipartFile f : files) {
					i++;
					if (!f.isEmpty()) {
						try {
							String directoryPath = System.getProperty("user.home")+ "/TrainingSession/"	+ training.getEmployeeId();
							System.out.println("*******FilePath : "	+ directoryPath);
							File dir = new File(directoryPath);
							if (!dir.exists()) {
								dir.mkdirs();
								System.out.println("Directory: " + dir);

							}
							String fileName = directoryPath + "/"
									+ training.getEmployeeId() + "_"
									+ f.getOriginalFilename();
							File file = new File(fileName);
							if (file.exists()) {

								Object[] options = { "Yes", "No", "Cancel" };
								int n = JOptionPane.showOptionDialog(null,
										"File aready exists.\n"
												+ "Overwrite existing file?",
										"Warning", JOptionPane.YES_NO_OPTION,
										JOptionPane.WARNING_MESSAGE, null,
										options, options[2]);

								if (n == 0) {
									try {
										file.delete();
									} catch (Exception e) {
										JOptionPane
												.showMessageDialog(null,
														"Error deleting file.\nClose the file if it is open.");
										return "TrainingEntry";
									}
								} else {
									return "TrainingEntry";
								}
							}
							System.out.println("********* PATH: " + fileName);
							outputStream = new FileOutputStream(file);
							outputStream.write(f.getBytes());
							outputStream.close();
							dbfileName = bean.getEmployeeId() + "_"+ f.getOriginalFilename();
							System.out.println("APPEND: " + dbfileName);
							if(i==1){
								training.setAttachFile1(dbfileName);
							}
							if(i==2){
								training.setAttachFile2(dbfileName);
							}
							if(i==3){
								training.setAttachFile3(dbfileName);
							}
							System.out.println("APPEND: " + dbfileName);
						} catch (FileNotFoundException e) {
							System.out.println("File not found" + e);
						}
					}
				}
			}
			
			if(!filePath.toString().equals(training.getFilePath())) {
				training.setFilePath(filePath.toString());
			}*/
					
			errors = doValidate(training);
			System.out.println("ERRORS: " + errors.toString());
			
			if (errors.isEmpty()) {				
				Boolean updateTraining = trainingeditDAO.updateTraining(training);
				if (updateTraining) {
					model.addAttribute("training", training);
					return "Success";
				}
			} else {
				model.addAttribute("errors", errors);
				return "TrainingEdit";
			}
		}
		return "TrainingEdit";
	}

	private Map<String, String> doValidate(Training training) {
		HashMap<String, String> errors = new HashMap<String, String>();

		if (Validator.isBlank(training.getEmployeeId())) {
			errors.put("300", "Training ID is required");
		} else if (Validator.isBlank(training.getTrainingname())) {
			errors.put("301", "Training Name is required");
		} else if (Validator.isBlank(training.getTrainingdescription())) {
			errors.put("302", "Training Description is required");
		} else if (Validator.isBlank(training.getPrerequistics())) {
			errors.put("303", "Pre Requistics is required");
		} else if (Validator.isBlank(training.getDate())) {
			errors.put("304", "Date is required");
		} else if (Validator.isBlank(training.getTime())) {
			errors.put("305", "Time is required");
		} else if (Validator.isBlank(training.getVenue())) {
			errors.put("306", "Venue is required");
		} else if (Validator.isBlank(training.getContactperson())) {
			errors.put("307", "Contact Person is required");
		}

		return errors;
	}
}
