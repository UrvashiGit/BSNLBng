package com.sterlite.bsnl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.model.SingleBNGInstAndCmsnModel;
import com.sterlite.bsnl.services.IBngService;

@Controller
public class BNGInstallationAndCommisionController {
	
	@Autowired
	private IBngService bngMasterService;
	
	@RequestMapping(value="/bngIAndCStatus", method=RequestMethod.GET)
	 public ModelAndView getAllBngIAndCStatus(HttpServletRequest req, HttpServletResponse res){
		List<BngMaster> bngMasterList = bngMasterService.getBngMasterList();
		return new ModelAndView("bngSiteDetailsForIAndC","bngList",bngMasterList);	
	}
	
	@RequestMapping(value="/singleBNGDetails", method=RequestMethod.GET)
	 public ModelAndView getSingleBngIAndCStatus(HttpServletResponse response,@RequestParam("getBNGID") String strBNGID,
			 @RequestParam("currentOrder") int currentOrder){
		System.out.println("CONTROLLER >>>>>>>>>>>>: "+currentOrder);
		Map<String,SingleBNGInstAndCmsnModel> singleBNGInstAndCmsMap = bngMasterService.getSingleBNGIAndCStatus(strBNGID,currentOrder);
		
		return new ModelAndView("singleBNGSiteDetailsForIAndC","singleMap",singleBNGInstAndCmsMap);	
	}
	
	
	@RequestMapping(value="/updateSiteSurvey", method=RequestMethod.POST)
	 public ModelAndView updateSingleBngIAndCStatus(HttpServletRequest req, HttpServletResponse res,@ModelAttribute("SingleBNGInstAndCmsnModel")SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel){
//		/Map<String,SingleBNGInstAndCmsnModel> singleBNGInstAndCmsMap = bngMasterService.getSingleBNGIAndCStatus(strBNGID);
		System.out.println("Inside updateSiteSurvey() ????????????"+singleBNGInstAndCmsnModel.toString());
		
	 /***
	  * Code for update data inside TBLBNGINSTANDCOMMISTAGE
	  * Auditing code 
	  * 
	  */
		
		bngMasterService.updateBngINSStage(singleBNGInstAndCmsnModel);
		String status = bngMasterService.getBngICStageStatusByStageId(singleBNGInstAndCmsnModel.getBngid(),singleBNGInstAndCmsnModel.getOrderId());
		String url = null;
		if(status != null) {
			if(status.equals("InProgress")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}else if(status.equals("Completed")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1;
			}else if(status.equals("Pending")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}
			
		}
		return new ModelAndView("redirect:/singleBNGDetails?getBNGID="+singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1);
	}
	
	
	

}