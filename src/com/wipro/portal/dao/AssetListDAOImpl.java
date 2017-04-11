package com.wipro.portal.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.ArrayList;
//import org.hibernate.Query;
//import java.util.Iterator;
import java.util.List;

import com.wipro.portal.dao.BaseDAO;
import com.wipro.portal.dao.AssetListDAO;
import com.wipro.portal.domain.Asset;


public class AssetListDAOImpl extends BaseDAO implements AssetListDAO {
 
 @Override
 @SuppressWarnings("unchecked")
 public List<Asset> ListAsset(){
  List<Asset> assets=null;
  
  try{
   Session session = sessionFactory.openSession();       
   String HQL_QUERY ="from Asset";
   assets= session.createQuery(HQL_QUERY).list();
   _log.info("asset"+assets);
   session.close();

  }catch(Exception e){
   e.printStackTrace();
  }
  return assets;
  
 }

 @Override
 public List findFreeAssetListByassetType(String assetType) {
	 List astList= new ArrayList();

	 try {
		 System.out.println("ASSET TYPE=="+assetType);	
		 Session session = sessionFactory.openSession();
		 String HQL_QUERY = "from Asset  where  assetType = '"+assetType+"' and assetStatus ='FREE'" ;
		 Query hqlQuery = session.createQuery(HQL_QUERY);
		 List lit = hqlQuery.list();
		 
		 if(lit!=null && lit.size() > 0) {
			
			 for(int i =0; i < lit.size(); i++) {
				 Asset asset = (Asset) lit.get(i);
				 astList.add(asset.getAssetId());

			 }
		 }
		 session.close();

	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	 
	 return astList;
 }

 @Override
 public List<Asset> ListAllocatedAssetsToFree() {
 	// TODO Auto-generated method stub
 	  List<Asset> assets=null;
 	  
 	  try{
	 	   Session session = sessionFactory.openSession();       
	 	   String HQL_QUERY ="from Asset where assetStatus = 'ALLOCATED' ";
	 	   assets= session.createQuery(HQL_QUERY).list();
	 	   _log.info("asset"+assets);
	 	   session.close();

 	  }catch(Exception e){
 	   e.printStackTrace();
 	  }
 	  return assets;
 }

 }