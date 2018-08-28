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

public class CircleWiseDetailedReportExcelBuilder extends AbstractXlsxView  {


	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		@SuppressWarnings("unchecked")
		  List<Book> books = (List<Book>) model.get("bookList");
		
		Sheet sheet = workbook.createSheet("CircleWiseDetailedReport");
		//Phase	Circle Name	Circle Code	Total BNG	Site Survey	Site Ready	Material Delivery	Power On	NW Integration	AT	Commissinong	ATC	ERP PO	MIGO	MIRO	Payment Status
		Row header = sheet.createRow(0);
		
		header.createCell(0).setCellValue("Phase");
		header.createCell(1).setCellValue("Circle Name");
		header.createCell(2).setCellValue("Circle Code");
		header.createCell(3).setCellValue("Location");
		header.createCell(4).setCellValue("SSA Code");
		header.createCell(5).setCellValue("BNG Type");
		header.createCell(6).setCellValue("Exist/New/Train");
		header.createCell(7).setCellValue("BNG ID");
		header.createCell(8).setCellValue("Site Survey");
		header.createCell(9).setCellValue("Site Ready");
		header.createCell(10).setCellValue("Material Delivery");
		header.createCell(11).setCellValue("Power On");
		header.createCell(12).setCellValue("NW Integration");
		header.createCell(13).setCellValue("AT");
		header.createCell(14).setCellValue("Commissinong");
		header.createCell(15).setCellValue("ATC");
		header.createCell(16).setCellValue("ERP OP");
		header.createCell(17).setCellValue("MIGO");
		header.createCell(18).setCellValue("MIRO");
		header.createCell(19).setCellValue("Payment Status");

		
		int rowCount = 1;
		for (Book book :books) {
			Row bookRow = sheet.createRow(rowCount++);
			bookRow.createCell(0).setCellValue(book.getName());
			bookRow.createCell(1).setCellValue(book.getAuthor());
			bookRow.createCell(2).setCellValue(book.getPublication());
		}

		
	}
}
