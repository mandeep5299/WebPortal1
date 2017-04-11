package com.wipro.portal.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.wipro.portal.domain.Asset;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.Iterator;


public class AssetEntryDAOImpl extends BaseDAO implements AssetEntryDAO {


	@Override
	public void saveAsset(Asset asset) {

		hibernateTemplate.saveOrUpdate(asset);
	

	}
}

