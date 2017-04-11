package com.wipro.portal.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sun.xml.internal.ws.api.server.Module;
import com.wipro.portal.domain.Asset;
import com.wipro.portal.domain.Training;

public class TrainingListDAOImpl extends BaseDAO implements TrainingListDAO {
	@Override
	@SuppressWarnings("unchecked")
	public List<Training> ListTraining() {
		List<Training> trainings = null;

		try {
			Session session = sessionFactory.openSession();
			String HQL_QUERY = "from Training";
			trainings = session.createQuery(HQL_QUERY).list();
			_log.info("asset" + trainings);
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainings;

	}

}
