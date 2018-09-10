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
import com.sterlite.bsnl.model.SummaryModel;

public class CircleWiseSummeryReportExcelBuilder extends AbstractXlsxView  {


	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		@SuppressWarnings("unchecked")
		  List<SummaryModel> circleWiseSummaryList = (List<SummaryModel>) model.get("cwsList");
		
		Sheet sheet = workbook.createSheet("CircleWiseSummeryReport");
		//Phase	Circle Name	Circle Code	Total BNG	Site Survey	Site Ready	Material Delivery	Power On	NW Integration	AT	Commissinong	ATC	ERP PO	MIGO	MIRO	Payment Status
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Phase");
		header.createCell(1).setCellValue("Circle Name");
		header.createCell(2).setCellValue("Circle Code");
		header.createCell(3).setCellValue("Total BNG");
		header.createCell(4).setCellValue("Site Survey");
		header.createCell(5).setCellValue("Site Ready");
		header.createCell(6).setCellValue("Material Delivery");
		header.createCell(7).setCellValue("Power On");
		header.createCell(8).setCellValue("NW Integration");
		header.createCell(9).setCellValue("AT");
		header.createCell(10).setCellValue("Commissinong");
		header.createCell(11).setCellValue("ATC");
		header.createCell(12).setCellValue("ERP OP");
		header.createCell(13).setCellValue("MIGO");
		header.createCell(14).setCellValue("MIRO");
		header.createCell(15).setCellValue("Payment Status");
		
		int rowCount = 1;
		for (SummaryModel singleSummaryModel :circleWiseSummaryList) {
			Row cwsRow = sheet.createRow(rowCount++);
			cwsRow.createCell(0).setCellValue(singleSummaryModel.getPhase());
			cwsRow.createCell(1).setCellValue(singleSummaryModel.getCircleName());
			cwsRow.createCell(2).setCellValue(singleSummaryModel.getCircleCode());
			cwsRow.createCell(3).setCellValue(singleSummaryModel.getTotalBng());
			cwsRow.createCell(4).setCellValue(singleSummaryModel.getSiteSurvey());
			cwsRow.createCell(5).setCellValue(singleSummaryModel.getSiteReady());
			cwsRow.createCell(6).setCellValue(singleSummaryModel.getMaterialDelivery());
			cwsRow.createCell(7).setCellValue(singleSummaryModel.getPowerOn());
			cwsRow.createCell(8).setCellValue(singleSummaryModel.getNWIntegration());
			cwsRow.createCell(9).setCellValue(singleSummaryModel.getAT());
			cwsRow.createCell(10).setCellValue(singleSummaryModel.getCommissioning());
			cwsRow.createCell(11).setCellValue(singleSummaryModel.getATC());
			cwsRow.createCell(12).setCellValue(singleSummaryModel.getERPPO());
			cwsRow.createCell(13).setCellValue(singleSummaryModel.getMIGO());
			cwsRow.createCell(14).setCellValue(singleSummaryModel.getMIRO());
			cwsRow.createCell(15).setCellValue(singleSummaryModel.getPaymentStatus());
		}

		
	}
}
