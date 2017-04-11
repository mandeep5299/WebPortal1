package com.wipro.portal.dao;

import com.wipro.portal.domain.Employee;

public interface EmployeeEditDAO {
	public Employee searchEmployee(int id) ;
	public Boolean updateEmployee(Employee employee);
	public Boolean deleteEmployee(Employee employeeId) ;
}
