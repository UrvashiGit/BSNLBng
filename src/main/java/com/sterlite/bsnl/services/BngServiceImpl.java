package com.sterlite.bsnl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sterlite.bsnl.dao.IBngMasterDAO;
import com.sterlite.bsnl.entity.BngMaster;

@Service
public class BngServiceImpl implements IBngService {

	@Autowired
	IBngMasterDAO bngMasterDao;
	
	@Override
	public List<BngMaster> getBngMasterList() {
		return bngMasterDao.getBngMasterList();
	}

}
