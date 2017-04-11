package com.wipro.portal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.wipro.portal.domain.Training;

public class SearchTrainingDAOImpl extends BaseDAO implements SearchTrainingDAO {
	@Override
	@SuppressWarnings("unchecked")
	public List<Training> SearchTraining(HttpSession sesion)
	{
		List<Training> training = null;
		String name=sesion.getAttribute("TrainingName").toString();
		int id =Integer.parseInt(sesion.getAttribute("EmployeeId").toString());
		String venue = sesion.getAttribute("Venue").toString();
		String time = sesion.getAttribute("Time").toString();
		String date = sesion.getAttribute("Date").toString();
						
		try {
			StringBuffer QUERY = new StringBuffer("from Training where");
			String andOperation=" AND ";
			if (name == "" && id == 0 && venue == "" && time == "" && date == "" ) {
				_log.info("EMPTY");
				QUERY.delete(QUERY.length()-6, QUERY.toString().length());
				_log.info(QUERY.toString());
			}
			else{
				if(name != ""){
					QUERY.append(" trainingname = '"+name+"'");
				}
				if(id != 0){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"employeeId = "+id);					
				}
				if(venue != ""){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"venue = '"+venue+"'");
				}				
				if(date != ""){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"date = '"+date+"'");
				}
				if(time != ""){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"time = '"+time+"'");
				}				
			}
						
			_log.info("QUERY: "+QUERY);
			Session session = sessionFactory.openSession();
			
			training = session.createQuery(QUERY.toString()).list();
			_log.info("training");
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return training;
	}
}
