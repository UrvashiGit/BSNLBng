package com.sterlite.bsnl.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.Book;
import com.sterlite.bsnl.model.SummaryModel;
import com.sterlite.bsnl.model.ZoneWiseDetailed;
import com.sterlite.bsnl.services.IBngService;
import com.sterlite.bsnl.services.IBookStoreService;
import com.sterlite.bsnl.utill.reportbuilder.BNGSiteDetailsReportPDFBuilder;
import com.sterlite.bsnl.utill.reportbuilder.CircleWiseDetailedReportPdfBuilder;
import com.sterlite.bsnl.utill.reportbuilder.CircleWiseSummeryReportPdfBuilder;
import com.sterlite.bsnl.utill.reportbuilder.ZoneWiseDetailedReportPdfBuilder;
import com.sterlite.bsnl.utill.reportbuilder.ZoneWiseSummeryReportPdfBuilder;

@RestController
public class PdfReportController {

	@Autowired
	private IBookStoreService service;
	
	@Autowired
	private IBngService bngMasterService;
	
	// ZoneWiseSummeryReport
	@RequestMapping(value = "/zoneWiseSummeryReportPdfDownload", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfReport() throws IOException {
		
		//List<Book> books = service.getBooks();
		List<SummaryModel> zoneWiseSummaryList = bngMasterService.getZoneWiseSummeryReport();
		
		ByteArrayInputStream bis = ZoneWiseSummeryReportPdfBuilder.generateReport(zoneWiseSummaryList);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=ZoneWiseSummeryReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
	
	// ZoneWiseDetailedReport
	@RequestMapping(value = "/zoneWiseDetailedReportPdfDownload", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> zoneWiseDetailedReportPdfDownload() throws IOException {
		
		//List<Book> books = service.getBooks();	
		List<ZoneWiseDetailed> zoneWiseDetailedList = bngMasterService.getZoneWiseDetailedReport();
		ByteArrayInputStream bis = ZoneWiseDetailedReportPdfBuilder.generateReport(zoneWiseDetailedList);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
	
	// CircleWiseSummeryReport
	@RequestMapping(value = "/circleWiseSummeryReportPdfDownload", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> circleWiseSummeryReportPdfDownload() throws IOException {
		
		//List<Book> books = service.getBooks();	
		List<SummaryModel> circleWiseSummaryList = bngMasterService.getCircleWiseSummeryReport();
		ByteArrayInputStream bis = CircleWiseSummeryReportPdfBuilder.generateReport(circleWiseSummaryList);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=CircleWiseSummeryReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
	
	// CircleWiseDetailedReport
	@RequestMapping(value = "/circleWiseDetailedReportPdfDownload", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> circleWiseDetailedReportPdfDownload() throws IOException {
		
		//List<Book> books = service.getBooks();
		List<ZoneWiseDetailed> circleWiseDetailedList = bngMasterService.getCircleWiseDetailedReport();
		ByteArrayInputStream bis = CircleWiseDetailedReportPdfBuilder.generateReport(circleWiseDetailedList);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=CircleWiseDetailedReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
	
	// BNG Site Details PDF 
		@RequestMapping(value = "/bngSiteDetailsReportPdfDownload", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> bngSiteDetailsReportPdfDownload() throws IOException {
			
			//List<Book> books = service.getBooks();
			List<BngMaster> bngMasterList = bngMasterService.getBngMasterList();
			ByteArrayInputStream bis = BNGSiteDetailsReportPDFBuilder.generateReport(bngMasterList);
			System.out.println("size : "+bngMasterList.size());
			HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=BNGSiteDetailReport.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
		}
	
	
	
}
