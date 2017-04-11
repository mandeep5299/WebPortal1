package com.wipro.portal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.wipro.portal.domain.Asset;

public class SearchAssetDAOImpl extends BaseDAO implements SearchAssetDAO {
	@Override
	@SuppressWarnings("unchecked")
	public List<Asset> SearchAsset(HttpSession sesion)
	{
		List<Asset> assets = null;
		String name = sesion.getAttribute("assetName").toString();
		String id = sesion.getAttribute("assetId").toString();
		String brandName = sesion.getAttribute("brandName").toString();
		
		try {
			StringBuffer QUERY = new StringBuffer("from Asset where");
			String andOperation=" AND ";
			if (name == "" && id == "" && brandName == "") {
				_log.info("EMPTY");
				QUERY.delete(QUERY.length()-6, QUERY.toString().length());
				_log.info(QUERY.toString());
			}
			else{
				if(name != ""){
					QUERY.append(" assetname = '"+name+"'");
				}
				if(id != ""){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"assetid = '"+id+"'");					
				}
				if(brandName != ""){
					if(name == ""){
						andOperation = " ";
					}
					QUERY.append(andOperation+"brand = '"+brandName+"'");
				}
			}			
			
			_log.info("QUERY: "+QUERY);		
			
			Session session = sessionFactory.openSession();
			
			assets = session.createQuery(QUERY.toString()).list();
			_log.info("assets");
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return assets;
	}
}
