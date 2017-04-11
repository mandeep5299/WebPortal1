package com.wipro.portal.dao;

import org.hibernate.Session;
import org.hibernate.Query;
import java.util.Iterator;
import java.util.List;


import com.wipro.portal.dao.BaseDAO;
import com.wipro.portal.dao.EmployeeEntryDAO;
import com.wipro.portal.domain.Employee;

public class EmployeeEntryDAOImpl extends BaseDAO implements EmployeeEntryDAO
{
 
 @Override
 public void saveEmployee(Employee employee){
        hibernateTemplate.saveOrUpdate(employee);
}
}