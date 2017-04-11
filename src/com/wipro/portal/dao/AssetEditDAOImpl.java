package com.wipro.portal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import com.wipro.portal.domain.Asset;

public class AssetEditDAOImpl extends BaseDAO implements AssetEditDAO {
	
	@Override
	public Asset searchAsset(String assetId) {
		Asset ast=null;
		try {

			Session session = sessionFactory.openSession();
			String HQL_QUERY = "from Asset  where assetid like :assetId";
			_log.info("sdfghjkl"+HQL_QUERY);
			
			Query hqlQuery = session.createQuery(HQL_QUERY);
			_log.info("Search Asset"+hqlQuery);

			hqlQuery.setString("assetId", assetId);

			ast = (Asset) hqlQuery.list().get(0);

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ast;
	}

	@Override
	public Boolean updateAsset(Asset asset) {

		boolean b = false;

		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(asset);
			tr.commit();
			session.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
	
	@Override
	public Boolean deleteAsset(Asset assetId) {
		// TODO Auto-generated method stub
		Boolean ast=true;
		try {

			Session session = sessionFactory.openSession();
			String HQL_QUERY = "delete from Asset where assetid like :assetid";
			Query hqlQuery = session.createQuery(HQL_QUERY);
			hqlQuery.setString("assetid", assetId.getAssetId());
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






