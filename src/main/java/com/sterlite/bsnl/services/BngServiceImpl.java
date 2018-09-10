package com.sterlite.bsnl.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sterlite.bsnl.dao.IBngMasterDAO;
import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.CircularMaster;
import com.sterlite.bsnl.model.SingleBNGInstAndCmsnModel;
import com.sterlite.bsnl.model.SingleBNGInvModel;
import com.sterlite.bsnl.model.SummaryModel;
import com.sterlite.bsnl.model.ZoneWiseDetailed;

@Service
public class BngServiceImpl implements IBngService {

	@Autowired
	IBngMasterDAO bngMasterDao;
	
	@Override
	public List<BngMaster> getBngMasterList() {
		return bngMasterDao.getBngMasterList();
	}

	@Override
	public List<CircularMaster> getCircularMasterList() {
		// TODO Auto-generated method stub
		return bngMasterDao.getCircularMasterList();
	}

	@Override
	public List<ZoneWiseDetailed> getZoneWiseDetailedReport() {
		// TODO Auto-generated method stub
		System.out.println("Inside getZoneWiseDetailedReport()");
		List<ZoneWiseDetailed> resultList=bngMasterDao.getZoneWiseDetailedReportDAO();
		System.out.println("getZoneWiseDetailedReport : "+resultList);
		return resultList;
	}
	
	@Override
	public List<ZoneWiseDetailed> getCircleWiseDetailedReport() {
		// TODO Auto-generated method stub
		System.out.println("Inside getCircleWiseDetailedReport()");
		List<ZoneWiseDetailed> resultList=bngMasterDao.getCircleWiseDetailedReportDAO();
		System.out.println("getZoneWiseDetailedReport : "+resultList);
		return resultList;
	}
	
	@Override
	public List<SummaryModel> getZoneWiseSummeryReport() {
		// TODO Auto-generated method stub
		System.out.println("Inside getZoneWiseSummeryReport()");
		List<SummaryModel> resultList=bngMasterDao.getZoneWiseSummaryReportDAO();
		System.out.println("getZoneWiseSummeryReport : "+resultList);
		return resultList;
	}
	
	@Override
	public List<SummaryModel> getCircleWiseSummeryReport() {
		// TODO Auto-generated method stub
		System.out.println("Inside getCircleWiseSummeryReport()");
		List<SummaryModel> resultList=bngMasterDao.getCircleWiseSummaryReportDAO();
		System.out.println("getCircleWiseSummeryReport : "+resultList);
		return resultList;
	}
	
	@Override
	public Map<String, SingleBNGInstAndCmsnModel> getSingleBNGIAndCStatus(String bngId) {
		
		Map<String,SingleBNGInstAndCmsnModel> singleBNGInstAndCmsnModel=bngMasterDao.getSingleBNGIAndCStatusDAO(bngId);
		System.out.println("BngServiceImpl : "+singleBNGInstAndCmsnModel.size());
		
		
		return singleBNGInstAndCmsnModel;
	}
	
	@Override
	public Map<String, SingleBNGInvModel> getSingleBNGInv(String bngId) {
		
		Map<String,SingleBNGInvModel> singleBNGInvModel=bngMasterDao.getSingleBNGInvDAO(bngId);
		System.out.println("BngServiceImpl : "+singleBNGInvModel.size());
		
		
		return singleBNGInvModel;
	}
	
	
}
