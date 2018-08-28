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
import com.sterlite.bsnl.utill.reportbuilder.ZoneWiseSummeryReportPdfBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import java.io.ByteArrayInputStream;

@RestController
public class PdfReportController {

	@Autowired
	private IBookStoreService service;
	
	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfReport() throws IOException {
		
		List<Book> books = service.getBooks();	
		ByteArrayInputStream bis = ZoneWiseSummeryReportPdfBuilder.generateReport(books);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}

	
}
