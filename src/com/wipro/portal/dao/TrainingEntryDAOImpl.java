package com.wipro.portal.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.wipro.portal.domain.Training;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.Iterator;


public class TrainingEntryDAOImpl extends BaseDAO implements TrainingEntryDAO {


	@Override
	public void saveTraining(Training training) {

		hibernateTemplate.saveOrUpdate(training);

	}

}

