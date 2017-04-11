package com.wipro.portal.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.wipro.portal.domain.Visa;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.Iterator;


public class VisaDAOImpl extends BaseDAO implements VisaDAO {


	@Override
	public void saveVisa(Visa visa) {

		hibernateTemplate.saveOrUpdate(visa);

	}










}

