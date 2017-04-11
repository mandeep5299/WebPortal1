package com.wipro.portal.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import com.wipro.portal.domain.Employee;

public class EmployeeEditDAOImpl extends BaseDAO implements EmployeeEditDAO {
		
	@Override
	public Employee searchEmployee(int employeeId) {
		Employee emp=null;
		try {

			Session session = sessionFactory.openSession();
			String HQL_QUERY = "from Employee where employeeId like :employeeId";
			Query hqlQuery = session.createQuery(HQL_QUERY);
			
			hqlQuery.setInteger("employeeId", employeeId);

			emp = (Employee) hqlQuery.list().get(0);

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	
	public Boolean updateEmployee(Employee employee) {

		boolean b = false;

		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(employee);
			tr.commit();
			session.close();
			b = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;
	}
	
	@Override
	public Boolean deleteEmployee(Employee employeeId) {
		// TODO Auto-generated method stub
		Boolean ast=true;
		try {

			Session session = sessionFactory.openSession();
			String HQL_QUERY = "delete from Employee where employeeId like :employeeId";
			Query hqlQuery = session.createQuery(HQL_QUERY);
			hqlQuery.setInteger("employeeId", employeeId.getEmployeeID());
			_log.info("bag"+hqlQuery);
			hqlQuery.executeUpdate();
			System.out.println("executed delete");
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ast;
	}

	
	public static void main(String args[]) {

		Employee employee1 = new Employee();
		
		//employee1.setId(2);

		Session session = null;

		try {

			SessionFactory fact = new Configuration().configure()
					.buildSessionFactory();
			session = fact.openSession();
			Transaction tr = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class,
					new Integer(employee1.getEmployeeID()));
			_log.info("hukhuj" + employee);
			employee1.setEmployeeID(employee1.getEmployeeID());
			employee1.setName(employee1.getName());
			employee1.setBusinessUnit(employee1.getBusinessUnit());
			employee1.setStatus(employee1.getStatus());
			employee1.setContactNo(employee1.getContactNo());
			employee1.setAimChatID(employee1.getAimChatID());
			employee1.setAimMailID(employee1.getAimMailID());
			employee1.setAimChatID(employee1.getAimChatID());
			employee1.setAimMailID(employee1.getAimMailID());

			session.update(employee1);

			tr.commit();
			session.close();
			System.out.println("Update successfully!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

	
	
		
	

