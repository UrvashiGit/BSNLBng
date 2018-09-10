package com.sterlite.bsnl.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.Book;
import com.sterlite.bsnl.model.SummaryModel;
import com.sterlite.bsnl.model.ZoneWiseDetailed;
import com.sterlite.bsnl.services.IBngService;
import com.sterlite.bsnl.services.IBookStoreService;
import com.sterlite.bsnl.utill.reportbuilder.BNGSiteDetailsReportExcelBuilder;
import com.sterlite.bsnl.utill.reportbuilder.CircleWiseDetailedReportExcelBuilder;
import com.sterlite.bsnl.utill.reportbuilder.CircleWiseSummeryReportExcelBuilder;
import com.sterlite.bsnl.utill.reportbuilder.ZoneWiseDetailedReportExcelBuilder;
import com.sterlite.bsnl.utill.reportbuilder.ZoneWiseSummeryReportExcelBuilder;


@Controller
public class ExcelReportController {

	@Autowired
	private IBookStoreService service;
	
	@Autowired
	private IBngService bngMasterService;
	
	// Download Report
	@RequestMapping(value="/zoneWiseSummeryReportDownloadExcel", method=RequestMethod.GET)
	 public ModelAndView zoneWiseSummeryReportDownloadExcel(HttpServletRequest req, HttpServletResponse res){
		//List<Book> books = service.getBooks();	
		//List<BngMaster> bngMasterList = bngMasterService.getBngMasterList();
		List<SummaryModel> zoneWiseSummaryList = bngMasterService.getZoneWiseSummeryReport();
		//System.out.println("INside : "+ zoneWiseDetailedList);
		res.setContentType( "application/ms-excel" );
        res.setHeader( "Content-disposition", "attachment; filename=zoneWiseSummeryReport.xls" ); 
		return new ModelAndView(new ZoneWiseSummeryReportExcelBuilder(), "zwsList", zoneWiseSummaryList);
	
	}
	
	@RequestMapping(value="/circleWiseSummeryReportDownloadExcel", method=RequestMethod.GET)
	 public ModelAndView circleWiseSummeryReportDownloadExcel(HttpServletRequest req, HttpServletResponse res){
		//List<Book> books = service.getBooks();
		List<SummaryModel> circleWiseSummaryList = bngMasterService.getCircleWiseSummeryReport();
		res.setContentType( "application/ms-excel" );
       res.setHeader( "Content-disposition", "attachment; filename=circleWiseSummeryReport.xls" ); 
		return new ModelAndView(new CircleWiseSummeryReportExcelBuilder(), "cwsList", circleWiseSummaryList);
	
	}
	
	@RequestMapping(value="/zoneWiseDetailedReportDownloadExcel", method=RequestMethod.GET)
	 public ModelAndView zoneWiseDetailedReportDownloadExcel(HttpServletRequest req, HttpServletResponse res){
		//List<Book> books = service.getBooks();
		List<ZoneWiseDetailed> zoneWiseDetailedList = bngMasterService.getZoneWiseDetailedReport();
		res.setContentType( "application/ms-excel" );
      res.setHeader( "Content-disposition", "attachment; filename=zoneWiseDetailedReport.xls" ); 
		return new ModelAndView(new ZoneWiseDetailedReportExcelBuilder(), "zwdList", zoneWiseDetailedList);
	
	}
	
	@RequestMapping(value="/bngSiteDetailsReportDownloadExcel", method=RequestMethod.GET)
	 public ModelAndView bngSiteDetailsReportDownloadExcel(HttpServletRequest req, HttpServletResponse res){
		//List<Book> books = service.getBooks();
		List<BngMaster> bngMasterList = bngMasterService.getBngMasterList();
		res.setContentType( "application/ms-excel" );
      res.setHeader( "Content-disposition", "attachment; filename=bngSiteDetailsReport.xls" ); 
		return new ModelAndView(new BNGSiteDetailsReportExcelBuilder(), "bngList", bngMasterList);
	
	}
	
	@RequestMapping(value="/circleWiseDetailedReportDownloadExcel", method=RequestMethod.GET)
	 public ModelAndView circleWiseDetailedReportDownloadExcel(HttpServletRequest req, HttpServletResponse res){
		//List<Book> books = service.getBooks();	
		List<ZoneWiseDetailed> circleWiseDetailedList = bngMasterService.getCircleWiseDetailedReport();
		res.setContentType( "application/ms-excel" );
        res.setHeader( "Content-disposition", "attachment; filename=circleWiseDetailedReport.xls" ); 
		return new ModelAndView(new CircleWiseDetailedReportExcelBuilder(), "circleList", circleWiseDetailedList);
	
	}
	
	
	// Download Report end
	
	
	// View Report
	@RequestMapping(value="/zoneWiseSummeryReport", method=RequestMethod.GET)
	 public ModelAndView zoneWiseSummeryReport(HttpServletRequest req, HttpServletResponse res){
		//List<Book> books = service.getBooks();	
		List<SummaryModel> zoneWiseSummaryList = bngMasterService.getZoneWiseSummeryReport();
		System.out.println(">>>>>>>>>> zoneWiseSummeryReport >>>>>>>>>>>>>>>>>>>>>>");
		return new ModelAndView("zoneWiseSummeryReportView", "zwsList", zoneWiseSummaryList);
	
	}
	
	
	@RequestMapping(value="/circleWiseSummeryReport", method=RequestMethod.GET)
	 public ModelAndView circleWiseSummeryReport(HttpServletRequest req, HttpServletResponse res){
		//List<Book> books = service.getBooks();	
		List<SummaryModel> circleWiseSummaryList = bngMasterService.getCircleWiseSummeryReport();
		System.out.println(">>>>>>>>>> circleWiseSummeryReportView >>>>>>>>>>>>>>>>>>>>>>");
		return new ModelAndView("circleWiseSummeryReportView", "cwsList", circleWiseSummaryList);
	
	}
	
	@RequestMapping(value="/zoneWiseDetailedReport", method=RequestMethod.GET)
	 public ModelAndView zoneWiseDetailedReport(HttpServletRequest req, HttpServletResponse res){
		//List<Book> books = service.getBooks();	
		List<ZoneWiseDetailed> zoneWiseDetailedList = bngMasterService.getZoneWiseDetailedReport();
		System.out.println(">>>>>>>>>> zoneWiseDetailedReportView >>>>>>>>>>>>>>>>>>>>>>");
		return new ModelAndView("zoneWiseDetailedReportView", "zwdList", zoneWiseDetailedList);
	
	}
	
	@RequestMapping(value="/circleWiseDetailedReport", method=RequestMethod.GET)
	 public ModelAndView circleWiseSummeryReportView(HttpServletRequest req, HttpServletResponse res){
		//List<Book> books = service.getBooks();	
		List<ZoneWiseDetailed> circleWiseDetailedList = bngMasterService.getCircleWiseDetailedReport();
		System.out.println(">>>>>>>>>> circleWiseDetailedReportView >>>>>>>>>>>>>>>>>>>>>>");
		return new ModelAndView("circleWiseDetailedReportView", "cwdList", circleWiseDetailedList);
	
	}
	// View Report end

	@RequestMapping(value="/bngSiteDetailsReport", method=RequestMethod.GET)
	 public ModelAndView bngSiteDetailsReportView(HttpServletRequest req, HttpServletResponse res){
		List<BngMaster> bngMasterList = bngMasterService.getBngMasterList();
		return new ModelAndView("bngSiteDetailsReportView","bngList",bngMasterList);
	
	}

}
