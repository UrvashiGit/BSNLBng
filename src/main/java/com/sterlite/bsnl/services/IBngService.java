package com.sterlite.bsnl.services;

import java.util.List;
import java.util.Map;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.CircularMaster;
import com.sterlite.bsnl.model.SingleBNGInstAndCmsnModel;
import com.sterlite.bsnl.model.SingleBNGInvModel;
import com.sterlite.bsnl.model.SummaryModel;
import com.sterlite.bsnl.model.ZoneWiseDetailed;


public interface IBngService {
	
	List<BngMaster> getBngMasterList();
	
	String getBngICStageStatusByStageId(String bngId,int stageId);
	
	List<CircularMaster> getCircularMasterList(); 
	
	List<ZoneWiseDetailed> getZoneWiseDetailedReport();
	
	List<ZoneWiseDetailed> getCircleWiseDetailedReport();
	
    List<SummaryModel> getZoneWiseSummeryReport();
	
	List<SummaryModel> getCircleWiseSummeryReport();
	
	Map<String, SingleBNGInstAndCmsnModel> getSingleBNGIAndCStatus(String bngId,int currentOrderId);
	
	Map<String, SingleBNGInvModel> getSingleBNGInv(String bngId);
	
	//update TBLBNGINSTANDCOMMISTAGE
		int updateBngINSStage(SingleBNGInstAndCmsnModel singleModel);

		/*
		int updateBngINSMasterStage(SingleBNGInstAndCmsnModel singleModel);
		
		int AddBngINSAudit(SingleBNGInstAndCmsnModel singleModel);*/
	
	


}
