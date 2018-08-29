package com.sterlite.bsnl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.Book;

@Transactional
@Repository
public class BngMasterDaoImpl implements IBngMasterDAO {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public List<BngMaster> getBngMasterList() {
		String hql = "FROM BngMaster as atcl ORDER BY atcl.id";
		return (List<BngMaster>) entityManager.createQuery(hql).getResultList();
	}

}
