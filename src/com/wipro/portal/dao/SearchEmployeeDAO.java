package com.wipro.portal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.wipro.portal.domain.Employee;

public interface SearchEmployeeDAO {
	public List<Employee> SearchEmployee(HttpSession sesion);

}
