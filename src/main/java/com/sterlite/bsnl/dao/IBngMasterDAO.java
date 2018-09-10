package com.sterlite.bsnl.dao;

import java.util.List;
import java.util.Map;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.CircularMaster;
import com.sterlite.bsnl.model.SingleBNGInstAndCmsnModel;
import com.sterlite.bsnl.model.SingleBNGInvModel;
import com.sterlite.bsnl.model.SummaryModel;
import com.sterlite.bsnl.model.ZoneWiseDetailed;


public interface IBngMasterDAO {
	
	List<BngMaster> getBngMasterList();

	List<CircularMaster> getCircularMasterList();
	
	List<ZoneWiseDetailed> getZoneWiseDetailedReportDAO();
	
	List<ZoneWiseDetailed> getCircleWiseDetailedReportDAO();
	
	List<SummaryModel> getZoneWiseSummaryReportDAO();
	
	List<SummaryModel> getCircleWiseSummaryReportDAO();
	
	Map<String, SingleBNGInstAndCmsnModel> getSingleBNGIAndCStatusDAO(String bngId);
	
	Map<String, SingleBNGInvModel> getSingleBNGInvDAO(String bngId);
	
	
	
}
