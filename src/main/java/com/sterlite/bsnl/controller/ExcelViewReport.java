package com.sterlite.bsnl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sterlite.bsnl.entity.Book;
import com.sterlite.bsnl.services.IBookStoreService;

public class ExcelViewReport extends AbstractXlsxView  {


	
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"books.xlsx\"");
		
		@SuppressWarnings("unchecked")
		  List<Book> books = (List<Book>) model.get("bookList");
		
		Sheet sheet = workbook.createSheet("testExcel");

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Name");
		header.createCell(1).setCellValue("Auther");
		header.createCell(2).setCellValue("Publication");
		
		
		int rowCount = 1;
		for (Book book :books) {
			Row bookRow = sheet.createRow(rowCount++);
			bookRow.createCell(0).setCellValue(book.getName());
			bookRow.createCell(1).setCellValue(book.getAuthor());
			bookRow.createCell(2).setCellValue(book.getPublication());
		}

		
	}

}
