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
	
	List<CircularMaster> getCircularMasterList(); 
	
	List<ZoneWiseDetailed> getZoneWiseDetailedReport();
	
	List<ZoneWiseDetailed> getCircleWiseDetailedReport();
	
    List<SummaryModel> getZoneWiseSummeryReport();
	
	List<SummaryModel> getCircleWiseSummeryReport();
	
	Map<String, SingleBNGInstAndCmsnModel> getSingleBNGIAndCStatus(String bngId);
	
	Map<String, SingleBNGInvModel> getSingleBNGInv(String bngId);
	
	


}
