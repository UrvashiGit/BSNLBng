package com.sterlite.bsnl.utill.reportbuilder;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sterlite.bsnl.entity.Book;

public class ZoneWiseSummeryReportExcelBuilder extends AbstractXlsxView  {


	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		@SuppressWarnings("unchecked")
		  List<Book> books = (List<Book>) model.get("bookList");
		
		Sheet sheet = workbook.createSheet("ZoneWiseSummeryReport");
//Phase	Zone Name	Total BNG	Site Survey Site Ready	Material Delivery	Power On	NW Integration	AT	Commissinong	ATC	ERP PO	MIGO	MIRO	Payment Status
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Phase");
		header.createCell(1).setCellValue("Zone Name");
		header.createCell(2).setCellValue("Total BNG");
		header.createCell(3).setCellValue("Site Survey");
		header.createCell(4).setCellValue("Site Ready");
		header.createCell(5).setCellValue("Material Delivery");
		header.createCell(6).setCellValue("Power On");
		header.createCell(7).setCellValue("NW Integration");
		header.createCell(8).setCellValue("AT");
		header.createCell(9).setCellValue("Commissinong");
		header.createCell(10).setCellValue("ATC");
		header.createCell(11).setCellValue("ERP OP");
		header.createCell(12).setCellValue("MIGO");
		header.createCell(13).setCellValue("MIRO");
		header.createCell(14).setCellValue("Payment Status");
		
		int rowCount = 1;
		for (Book book :books) {
			Row bookRow = sheet.createRow(rowCount++);
			bookRow.createCell(0).setCellValue(book.getName());
			bookRow.createCell(1).setCellValue(book.getAuthor());
			bookRow.createCell(2).setCellValue(book.getPublication());
		}

		
	}
}
