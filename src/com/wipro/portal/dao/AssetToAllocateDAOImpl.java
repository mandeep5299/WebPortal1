package com.wipro.portal.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.wipro.portal.domain.AllocateAsset;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.Iterator;


public class AssetToAllocateDAOImpl extends BaseDAO implements AssetToAllocateDAO {


	@Override
	public void saveAllocateAsset(AllocateAsset asset) {

		hibernateTemplate.saveOrUpdate(asset);

	}










}

