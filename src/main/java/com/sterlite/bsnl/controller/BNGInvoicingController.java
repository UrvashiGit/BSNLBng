package com.sterlite.bsnl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.model.SingleBNGInvModel;
import com.sterlite.bsnl.services.IBngService;

@Controller
public class BNGInvoicingController {
	
	@Autowired
	private IBngService bngMasterService;
	
	@RequestMapping(value="/bngInvoicing", method=RequestMethod.GET)
	 public ModelAndView getAllBngIAndCStatus(HttpServletRequest req, HttpServletResponse res){
		List<BngMaster> bngMasterList = bngMasterService.getBngMasterList();
		return new ModelAndView("bngSiteDetailsForInv","bngList",bngMasterList);	
	}
	
	@RequestMapping(value="/singleBNGInvDetails", method=RequestMethod.GET)
	 public ModelAndView getSingleBngInvoicing(HttpServletResponse response,@RequestParam("getBNGID") String strBNGID){
		Map<String,SingleBNGInvModel> singleBNGInvMap = bngMasterService.getSingleBNGInv(strBNGID);
		System.out.println("CONTROLLER : "+singleBNGInvMap.size());
		return new ModelAndView("singleBNGSiteDetailsForInv","singleMap",singleBNGInvMap);	
	}
	
	
	@RequestMapping(value="/updateSingleBNGInvDetails", method=RequestMethod.POST)
	 public ModelAndView updateSingleBngIAndCStatus(HttpServletRequest req, HttpServletResponse res){
//		/Map<String,SingleBNGInstAndCmsnModel> singleBNGInstAndCmsMap = bngMasterService.getSingleBNGIAndCStatus(strBNGID);
		System.out.println("Inside updateSsingleBNGDetails()");
		
	 /***
	  * Code for update data inside TBLBNGINSTANDCOMMISTAGE
	  * Auditing code 
	  * 
	  */
		return new ModelAndView("singleBNGSiteDetailsForIAndC","singleMap","");	
	}
}
