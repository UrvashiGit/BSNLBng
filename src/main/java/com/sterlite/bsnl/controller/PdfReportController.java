package com.sterlite.bsnl.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sterlite.bsnl.entity.Book;
import com.sterlite.bsnl.services.IBookStoreService;
import com.sterlite.bsnl.utill.reportbuilder.CircleWiseDetailedReportPdfBuilder;
import com.sterlite.bsnl.utill.reportbuilder.CircleWiseSummeryReportPdfBuilder;
import com.sterlite.bsnl.utill.reportbuilder.ZoneWiseDetailedReportPdfBuilder;
import com.sterlite.bsnl.utill.reportbuilder.ZoneWiseSummeryReportPdfBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import java.io.ByteArrayInputStream;

@RestController
public class PdfReportController {

	@Autowired
	private IBookStoreService service;
	
	// ZoneWiseSummeryReport
	@RequestMapping(value = "/zoneWiseSummeryReportPdfDownload", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfReport() throws IOException {
		
		List<Book> books = service.getBooks();
		
		ByteArrayInputStream bis = ZoneWiseSummeryReportPdfBuilder.generateReport(books);
		
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
		
		List<Book> books = service.getBooks();	
		ByteArrayInputStream bis = ZoneWiseDetailedReportPdfBuilder.generateReport(books);
		
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
		
		List<Book> books = service.getBooks();	
		ByteArrayInputStream bis = CircleWiseSummeryReportPdfBuilder.generateReport(books);
		
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
		
		List<Book> books = service.getBooks();	
		ByteArrayInputStream bis = CircleWiseDetailedReportPdfBuilder.generateReport(books);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=CircleWiseDetailedReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}

	
}
