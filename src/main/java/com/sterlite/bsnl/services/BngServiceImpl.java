package com.sterlite.bsnl.services;

import java.util.Date;
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
	public Map<String, SingleBNGInstAndCmsnModel> getSingleBNGIAndCStatus(String bngId,int currentOrderId) {
		
		Map<String,SingleBNGInstAndCmsnModel> singleBNGInstAndCmsnModel=bngMasterDao.getSingleBNGIAndCStatusDAO(bngId, currentOrderId);
		System.out.println("BngServiceImpl : "+singleBNGInstAndCmsnModel.size());
		
		
		return singleBNGInstAndCmsnModel;
	}
	
	@Override
	public Map<String, SingleBNGInvModel> getSingleBNGInv(String bngId,int currentOrderId) {
		
		Map<String,SingleBNGInvModel> singleBNGInvModel=bngMasterDao.getSingleBNGInvDAO(bngId,currentOrderId);
		System.out.println("BngServiceImpl : "+singleBNGInvModel.size());
		
		
		return singleBNGInvModel;
	}
	
	@Override
	public int updateBngINSStage(SingleBNGInstAndCmsnModel singleModel) {
	
		Date currentDate = new Date();
		Date givenCloseDate = singleModel.getCloseDate();
		Date givenTargetDate = singleModel.getTargetDate();
		
		if(givenCloseDate != null && givenTargetDate != null) {
			// if both date is equal then status is completed
			if(givenCloseDate.compareTo(givenTargetDate) == 0) {
				System.out.println("EQUAL >>");
				singleModel.setStatus("Completed");
				
			}else if(givenTargetDate.after(givenCloseDate)) {
				// if TD is greater then sysdate or GT then Close date(in case of TG EXtended) --> status = inProgress
				System.out.println("INPROGESS >>");
				singleModel.setStatus("InProgress");
			}
		}else if (givenTargetDate != null && givenCloseDate == null) {
			singleModel.setStatus("InProgress");
		}
		else {
			// if there is no date then Pending
			singleModel.setStatus("Pending");
		}

		return bngMasterDao.updateBngINSStage(singleModel);
	}

	@Override
	public String getBngICStageStatusByStageId(String bngId,int stageId) {
		return bngMasterDao.getBngICStageStatusByStageId(bngId,stageId);
	}

	
	@Override
	public int updateBngINVStage(SingleBNGInvModel singleModel) throws Exception {
	
		Date currentDate = new Date();
		Date givenCloseDate = singleModel.getCloseDate();
		Date givenTargetDate = singleModel.getTargetDate();
		
		if(givenCloseDate != null && givenTargetDate != null) {
			// if both date is equal then status is completed
			if(givenCloseDate.compareTo(givenTargetDate) == 0) {
				System.out.println("EQUAL >>");
				singleModel.setStatus("Completed");
				
			}
			// if TD is greater then sysdate or GT then Close date(in case of TG EXtended) --> status = inProgress
			if(givenTargetDate.compareTo(currentDate) > 0 || givenTargetDate.after(givenCloseDate)) {
				System.out.println("INPROGESS >>");
				singleModel.setStatus("InProgress");
			}
		}else if (givenTargetDate != null && givenCloseDate == null) {
			singleModel.setStatus("InProgress");
		}
		else {
			// if there is no date then Pending
			singleModel.setStatus("Pending");
		}

		return bngMasterDao.updateBngINVStage(singleModel);
	}
	
	
}
