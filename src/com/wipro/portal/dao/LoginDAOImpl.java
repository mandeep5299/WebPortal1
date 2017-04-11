package com.wipro.portal.dao;


import org.hibernate.Session;
import org.hibernate.Query;
import java.util.Iterator;
import java.util.List;

import com.wipro.portal.domain.Login;

public class LoginDAOImpl extends BaseDAO implements LoginDAO {


	@Override
	@SuppressWarnings("unchecked")
	public boolean validateUser(Login login){
		boolean retval=false;

		try{
			Session session = sessionFactory.openSession();    	  
			String HQL_QUERY ="from Login where username='"+login.getUname()+"' and password='"+login.getPassword()+"'";
			Query query = session.createQuery(HQL_QUERY);

			for(Iterator it=query.iterate();it.hasNext();){    				   
				Login row = (Login) it.next();
				retval=true;
			}

			session.close();

		}catch(Exception e){
			e.printStackTrace();
		}



		return retval;
	}

	public List<Login> getUserList(String userId){
		
		List<Login> login=null;
		try{
			Session session = sessionFactory.openSession();    	  
			String HQL_QUERY ="from Login where username='"+userId+"'";
			Query query = session.createQuery(HQL_QUERY);

			login=query.list();

			session.close();

		}catch(Exception e){
			e.printStackTrace();
		}



		return  login;
	}

}

