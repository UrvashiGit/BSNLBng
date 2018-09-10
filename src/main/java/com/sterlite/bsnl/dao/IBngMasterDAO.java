package com.sterlite.bsnl.dao;

import java.util.List;
import java.util.Map;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.CircularMaster;
import com.sterlite.bsnl.model.SingleBNGInstAndCmsnModel;
import com.sterlite.bsnl.model.SingleBNGInvModel;
import com.sterlite.bsnl.model.SummaryModel;
import com.sterlite.bsnl.model.ZoneWiseDetailed;

import org.hibernate.Session;


public interface IBngMasterDAO {
	
	List<BngMaster> getBngMasterList();

	String getBngICStageStatusByStageId(String bngId,int stageId);

	List<CircularMaster> getCircularMasterList();
	
	List<ZoneWiseDetailed> getZoneWiseDetailedReportDAO();
	
	List<ZoneWiseDetailed> getCircleWiseDetailedReportDAO();
	
	List<SummaryModel> getZoneWiseSummaryReportDAO();
	
	List<SummaryModel> getCircleWiseSummaryReportDAO();
	
    Map<String, SingleBNGInstAndCmsnModel> getSingleBNGIAndCStatusDAO(String bngId,int currentOrderId);
	
	Map<String, SingleBNGInvModel> getSingleBNGInvDAO(String bngId,int currentOrderId);
	
	//update TBLBNGINSTANDCOMMISTAGE
	int updateBngINSStage(SingleBNGInstAndCmsnModel singleModel);
			
	int updateBngINSMasterStage(SingleBNGInstAndCmsnModel singleModel,Session session);
	
	int updateBngINVStage(SingleBNGInvModel singleModel);
	
	 int updateBngINVMasterStage(SingleBNGInvModel singleModel,Session session);
			
	int insertAudit(Object singleModel,Session session);
}
