package com.wipro.portal.dao;

import java.util.logging.Logger;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDAO {

	public static final Logger _log = Logger.getLogger(BaseDAO.class.getName());

	protected HibernateTemplate hibernateTemplate;
	protected SessionFactory sessionFactory;
	protected DataSource dataSource;

	@Autowired
	public void setDAOConfig(DAOConfig daoConfig) {
		this.dataSource = daoConfig.getDataSource();
		this.sessionFactory = daoConfig.getSessionFactory();
		this.hibernateTemplate = new HibernateTemplate(this.sessionFactory);
	}
}
