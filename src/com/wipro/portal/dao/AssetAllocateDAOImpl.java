package com.wipro.portal.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.wipro.portal.domain.AllocateAsset;
import com.wipro.portal.domain.Asset;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import java.util.Iterator;


public class AssetAllocateDAOImpl extends BaseDAO implements AssetAllocateDAO {


	@Override
	public void saveAllocateAsset(AllocateAsset asset) {
		hibernateTemplate.saveOrUpdate(asset);
	}
	@Override
	public AllocateAsset searchAllocatedAssetData(String assetId, String assetType) {
		// TODO Auto-generated method stub
		
		AllocateAsset allocatedAsset=null;
		try {
			Session session = sessionFactory.openSession();
			Query hqlQuery = null;
			String HQL_QUERY = "";
			
			if(assetType.equalsIgnoreCase("CPU")){
				HQL_QUERY = "from AllocateAsset where cpuId like :cpuId";
				hqlQuery = session.createQuery(HQL_QUERY);
				hqlQuery.setString("cpuId", assetId);
			}
			if(assetType.equalsIgnoreCase("KEYBOARD")){
				HQL_QUERY = "from AllocateAsset where keyboardId like :keyboardId";
				hqlQuery = session.createQuery(HQL_QUERY);
				hqlQuery.setString("keyboardId", assetId);
			}
			if(assetType.equalsIgnoreCase("MOUSE")){
				HQL_QUERY = "from AllocateAsset where mouseId like :mouseId";
				hqlQuery = session.createQuery(HQL_QUERY);
				hqlQuery.setString("mouseId", assetId);
			}
			if(assetType.equalsIgnoreCase("MONITOR")){
				HQL_QUERY = "from AllocateAsset where monitorId like :monitorId";
				hqlQuery = session.createQuery(HQL_QUERY);
				hqlQuery.setString("monitorId", assetId);
			}
			allocatedAsset = (AllocateAsset) hqlQuery.list().get(0);
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allocatedAsset;

				
	}
	@Override
	public Boolean updateAllocatedAsset(AllocateAsset allocateasset) {
		// TODO Auto-generated method stub
		boolean b = false;

		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.update(allocateasset);
			tr.commit();
			session.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
		
	}
	@Override
	public AllocateAsset searchAllocatedAssetData(String searchEmployeeId) {
		// TODO Auto-generated method stub
		AllocateAsset allocatedAsset=null;
		try {
			Session session = sessionFactory.openSession();
			Query hqlQuery = null;
			String HQL_QUERY = "";
			HQL_QUERY = "from AllocateAsset where employeeId like :employeeId";
			hqlQuery = session.createQuery(HQL_QUERY);
			hqlQuery.setString("employeeId",searchEmployeeId);
			allocatedAsset = (AllocateAsset) hqlQuery.list().get(0);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allocatedAsset;
	}

}

