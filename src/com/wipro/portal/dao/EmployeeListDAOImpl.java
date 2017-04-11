package com.wipro.portal.dao;

import java.util.List;

import org.hibernate.Session;

import com.wipro.portal.domain.Employee;


public class EmployeeListDAOImpl  extends BaseDAO implements EmployeeListDAO  {
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> ListEmployee()
	{
		List<Employee> emp=null;

		try{
			Session session = sessionFactory.openSession();       
			String HQL_QUERY ="from Employee";
			emp= session.createQuery(HQL_QUERY).list();
			_log.info("emp");
			session.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return emp;
	}
}
