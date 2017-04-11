package com.wipro.portal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.wipro.portal.domain.Asset;
import com.wipro.portal.domain.Employee;

public class SearchEmployeeDAOImpl extends BaseDAO implements SearchEmployeeDAO {
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> SearchEmployee(HttpSession sesion)
	{
		List<Employee> emp = null;
		String name=sesion.getAttribute("EmployeeName").toString();
		int id =Integer.parseInt(sesion.getAttribute("EmployeeID").toString());
		String bussinessUnit = sesion.getAttribute("BussinessUnit").toString();
		long contactNo = Long.parseLong(sesion.getAttribute("ContactNumber").toString());
		String aimId = sesion.getAttribute("AimID").toString();
		String wiproId = sesion.getAttribute("WiproID").toString();
		String appleId = sesion.getAttribute("AppleID").toString();
						
		try {
			StringBuffer QUERY = new StringBuffer("from Employee where");
			String andOperation=" AND ";
			if (name == "" && id == 0 && bussinessUnit == "" && contactNo == 0 && aimId == "" && wiproId == "" && appleId =="") {
				_log.info("EMPTY");
				QUERY.delete(QUERY.length()-6, QUERY.toString().length());
				_log.info(QUERY.toString());
			}
			else{
				if(name != ""){
					QUERY.append(" Name = '"+name+"'");
				}
				if(id != 0){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"EmployeeID = "+id);					
				}
				if(bussinessUnit != ""){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"BusinessUnit = '"+bussinessUnit+"'");
				}
				if(contactNo != 0){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"ContactNo = '"+contactNo+"'");
				}
				if(aimId != ""){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"AIMMailID = '"+aimId+"'");
				}
				if(wiproId != ""){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"WiproMailID = '"+wiproId+"'");
				}
				if(appleId != ""){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"AppleMailID = '"+appleId+"'");
				}
			}
			
			
			_log.info("QUERY: "+QUERY);
			
			
			Session session = sessionFactory.openSession();
			
			emp = session.createQuery(QUERY.toString()).list();
			_log.info("emp");
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}
