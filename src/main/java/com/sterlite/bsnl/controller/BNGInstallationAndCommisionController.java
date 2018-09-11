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
	
	//1
	@RequestMapping(value="/updateSiteSurvey", method=RequestMethod.POST)
	 public ModelAndView updateSingleBngIAndCStatus(HttpServletRequest req, HttpServletResponse res,@ModelAttribute("SingleBNGInstAndCmsnModel")SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel) throws Exception{
		
		System.out.println("Inside updateSiteSurvey() ????????????"+singleBNGInstAndCmsnModel.toString());
		
		//Update I&C Status
		int i=bngMasterService.updateBngINSStage(singleBNGInstAndCmsnModel);
		
		//Get Current detail of BNG
		String status = bngMasterService.getBngICStageStatusByStageId(singleBNGInstAndCmsnModel.getBngid(),singleBNGInstAndCmsnModel.getOrderId());
		String url = null;
		if(status != null) {
			if(status.equals("In Progress")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}else if(status.equals("Closed")) {
				int currentBngOrderId = singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1;
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+currentBngOrderId;
			}else if(status.equals("Pending")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}
		}
		
		return new ModelAndView("redirect:/singleBNGDetails?getBNGID="+url);
	}
	
	//#2
	@RequestMapping(value="/updateSiteReady", method=RequestMethod.POST)
	 public ModelAndView updateSiteReady(HttpServletRequest req, HttpServletResponse res,@ModelAttribute("SingleBNGInstAndCmsnModel")SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel) throws Exception{
		
		System.out.println("Inside updateSiteReady() ????????????"+singleBNGInstAndCmsnModel.toString());
		
		//Update I&C Status
		bngMasterService.updateBngINSStage(singleBNGInstAndCmsnModel);
		
		//Get Current detail of BNG
		String status = bngMasterService.getBngICStageStatusByStageId(singleBNGInstAndCmsnModel.getBngid(),singleBNGInstAndCmsnModel.getOrderId());
		String url = null;
		if(status != null) {
			if(status.equals("In Progress")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}else if(status.equals("Closed")) {
				int currentBngOrderId = singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1;
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+currentBngOrderId;
			}else if(status.equals("Pending")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}
		}
		
		return new ModelAndView("redirect:/singleBNGDetails?getBNGID="+url);
	}
	//3
	@RequestMapping(value="/updateMD", method=RequestMethod.POST)
	 public ModelAndView updateMD(HttpServletRequest req, HttpServletResponse res,@ModelAttribute("SingleBNGInstAndCmsnModel")SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel) throws Exception{
		
		System.out.println("Inside updateMD() ????????????"+singleBNGInstAndCmsnModel.toString());
		
		//Update I&C Status
		bngMasterService.updateBngINSStage(singleBNGInstAndCmsnModel);
		
		//Get Current detail of BNG
		String status = bngMasterService.getBngICStageStatusByStageId(singleBNGInstAndCmsnModel.getBngid(),singleBNGInstAndCmsnModel.getOrderId());
		String url = null;
		if(status != null) {
			
			if(status.equals("In Progress")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}else if(status.equals("Closed")) {
				int currentBngOrderId = singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1;
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+currentBngOrderId;
			}else if(status.equals("Pending")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}
		}
		
		return new ModelAndView("redirect:/singleBNGDetails?getBNGID="+url);
	}
	//4
	@RequestMapping(value="/updatePowerOn", method=RequestMethod.POST)
	 public ModelAndView updatePowerOn(HttpServletRequest req, HttpServletResponse res,@ModelAttribute("SingleBNGInstAndCmsnModel")SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel) throws Exception{
		
		System.out.println("Inside updatePowerOn() ????????????"+singleBNGInstAndCmsnModel.toString());
		
		//Update I&C Status
		bngMasterService.updateBngINSStage(singleBNGInstAndCmsnModel);
		
		//Get Current detail of BNG
		String status = bngMasterService.getBngICStageStatusByStageId(singleBNGInstAndCmsnModel.getBngid(),singleBNGInstAndCmsnModel.getOrderId());
		String url = null;
		if(status != null) {
			if(status.equals("In Progress")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}else if(status.equals("Closed")) {
				int currentBngOrderId = singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1;
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+currentBngOrderId;
			}else if(status.equals("Pending")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}
		}
		
		return new ModelAndView("redirect:/singleBNGDetails?getBNGID="+url);
	}
	//5
	@RequestMapping(value="/updateNWI", method=RequestMethod.POST)
	 public ModelAndView updateNWI(HttpServletRequest req, HttpServletResponse res,@ModelAttribute("SingleBNGInstAndCmsnModel")SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel) throws Exception{
		
		System.out.println("Inside updateNWI() ????????????"+singleBNGInstAndCmsnModel.toString());
		
		//Update I&C Status
		bngMasterService.updateBngINSStage(singleBNGInstAndCmsnModel);
		
		//Get Current detail of BNG
		String status = bngMasterService.getBngICStageStatusByStageId(singleBNGInstAndCmsnModel.getBngid(),singleBNGInstAndCmsnModel.getOrderId());
		String url = null;
		if(status != null) {
			if(status.equals("In Progress")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}else if(status.equals("Closed")) {
				int currentBngOrderId = singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1;
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+currentBngOrderId;
			}else if(status.equals("Pending")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}
		}
		
		return new ModelAndView("redirect:/singleBNGDetails?getBNGID="+url);
	}
	//6
	@RequestMapping(value="/updateAT", method=RequestMethod.POST)
	 public ModelAndView updateAT(HttpServletRequest req, HttpServletResponse res,@ModelAttribute("SingleBNGInstAndCmsnModel")SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel) throws Exception{
		
		System.out.println("Inside updateAT() ????????????"+singleBNGInstAndCmsnModel.toString());
		
		//Update I&C Status
		bngMasterService.updateBngINSStage(singleBNGInstAndCmsnModel);
		
		//Get Current detail of BNG
		String status = bngMasterService.getBngICStageStatusByStageId(singleBNGInstAndCmsnModel.getBngid(),singleBNGInstAndCmsnModel.getOrderId());
		String url = null;
		if(status != null) {
			if(status.equals("In Progress")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}else if(status.equals("Closed")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1;
			}else if(status.equals("Pending")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}
		}
		
		return new ModelAndView("redirect:/singleBNGDetails?getBNGID="+url);
	}
	
	//7
	@RequestMapping(value="/updateCommissinong", method=RequestMethod.POST)
	 public ModelAndView updateCommissinong(HttpServletRequest req, HttpServletResponse res,@ModelAttribute("SingleBNGInstAndCmsnModel")SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel) throws Exception{
		
		System.out.println("Inside updateCommissinong() ????????????"+singleBNGInstAndCmsnModel.toString());
		
		//Update I&C Status
		bngMasterService.updateBngINSStage(singleBNGInstAndCmsnModel);
		
		//Get Current detail of BNG
		String status = bngMasterService.getBngICStageStatusByStageId(singleBNGInstAndCmsnModel.getBngid(),singleBNGInstAndCmsnModel.getOrderId());
		String url = null;
		if(status != null) {
			if(status.equals("In Progress")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}else if(status.equals("Closed")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1;
			}else if(status.equals("Pending")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}
		}
		
		return new ModelAndView("redirect:/singleBNGDetails?getBNGID="+url);
	}
	//8
	@RequestMapping(value="/updateATC", method=RequestMethod.POST)
	 public ModelAndView updateATC(HttpServletRequest req, HttpServletResponse res,@ModelAttribute("SingleBNGInstAndCmsnModel")SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel) throws Exception{
		
		System.out.println("Inside updateATC() ????????????"+singleBNGInstAndCmsnModel.toString());
		
		//Update I&C Status
		bngMasterService.updateBngINSStage(singleBNGInstAndCmsnModel);
		
		//Get Current detail of BNG
		String status = bngMasterService.getBngICStageStatusByStageId(singleBNGInstAndCmsnModel.getBngid(),singleBNGInstAndCmsnModel.getOrderId());
		String url = null;
		if(status != null) {
			if(status.equals("In Progress")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}else if(status.equals("Closed")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId()+1;
			}else if(status.equals("Pending")) {
				url = singleBNGInstAndCmsnModel.getBngid()+"&currentOrder="+singleBNGInstAndCmsnModel.getCurrentBNGOrderId();
			}
		}
		
		return new ModelAndView("redirect:/singleBNGDetails?getBNGID="+url);
	}
	//8
	
	
	
	

}