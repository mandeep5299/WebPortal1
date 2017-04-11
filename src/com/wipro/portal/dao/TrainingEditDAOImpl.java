package com.wipro.portal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import com.wipro.portal.domain.Training;

public class TrainingEditDAOImpl extends BaseDAO implements TrainingEditDAO {



	@Override
	public Training searchTraining(int trainingId) {
		// TODO Auto-generated method stub
		Training training = null;
		try {

			Session session = sessionFactory.openSession();
			String HQL_QUERY = "from Training where trainingId =:trainingId";
			
			Query hqlQuery = session.createQuery(HQL_QUERY);
			
			hqlQuery.setInteger("trainingId", trainingId);
			
			training = (Training) hqlQuery.list().get(0);

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return training;
	}

	@Override
	public Training findByTrainingId(int trainingId) {
		Training training = null;
		try {
			Session session = sessionFactory.openSession();
			String HQL_QUERY = "from Training where trainingId =:trainingId";

			Query hqlQuery = session.createQuery(HQL_QUERY);

			hqlQuery.setInteger("trainingId", trainingId);
			List list = hqlQuery.list();
			if(list!=null) {
				training = (Training) list.get(0);
			}
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return training;
	}
	 
	
	@Override
	public Boolean updateTraining(Training training) {
		boolean b = false;
		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(training);
			tr.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	

	@Override
	public Boolean deleteTraining(Training training) {
		// TODO Auto-generated method stub
		Boolean ast=true;
		try {

			Session session = sessionFactory.openSession();
			String HQL_QUERY = "delete from Training where trainingId like :trainingId";
			Query hqlQuery = session.createQuery(HQL_QUERY);
			hqlQuery.setInteger("trainingId", training.getTrainingId());
			_log.info("bag"+hqlQuery);
			hqlQuery.executeUpdate();
			System.out.println("executed delete");
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ast;
	}

}
