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
import com.sterlite.bsnl.model.ZoneWiseDetailed;

public class CircleWiseDetailedReportExcelBuilder extends AbstractXlsxView  {


	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		@SuppressWarnings("unchecked")
		  List<ZoneWiseDetailed> circleWiseDetailedList = (List<ZoneWiseDetailed>) model.get("circleList");
		
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
		for (ZoneWiseDetailed circleWiseDetailedSingle :circleWiseDetailedList) {
			Row zwdRow = sheet.createRow(rowCount++);
			zwdRow.createCell(0).setCellValue(circleWiseDetailedSingle.getPhase());
			/*zwdRow.createCell(1).setCellValue(circleWiseDetailedSingle.getZoneName());*/
			zwdRow.createCell(1).setCellValue(circleWiseDetailedSingle.getCircleName());
			zwdRow.createCell(2).setCellValue(circleWiseDetailedSingle.getCircleCode());
			zwdRow.createCell(3).setCellValue(circleWiseDetailedSingle.getLocation());
			zwdRow.createCell(4).setCellValue(circleWiseDetailedSingle.getCircleName());
			zwdRow.createCell(5).setCellValue(circleWiseDetailedSingle.getSSACode());
			zwdRow.createCell(6).setCellValue(circleWiseDetailedSingle.getBNGType());
			zwdRow.createCell(7).setCellValue(circleWiseDetailedSingle.getExistNewTrain());
			zwdRow.createCell(8).setCellValue(circleWiseDetailedSingle.getBNGID());
			zwdRow.createCell(9).setCellValue(circleWiseDetailedSingle.getSiteSurvey());
			zwdRow.createCell(10).setCellValue(circleWiseDetailedSingle.getSiteReady());
			zwdRow.createCell(11).setCellValue(circleWiseDetailedSingle.getMaterialDelivery());
			zwdRow.createCell(12).setCellValue(circleWiseDetailedSingle.getPowerOn());
			zwdRow.createCell(13).setCellValue(circleWiseDetailedSingle.getNWIntegration());
			zwdRow.createCell(14).setCellValue(circleWiseDetailedSingle.getCommissioning());
			zwdRow.createCell(15).setCellValue(circleWiseDetailedSingle.getAT());
			zwdRow.createCell(16).setCellValue(circleWiseDetailedSingle.getERPPO());
			zwdRow.createCell(17).setCellValue(circleWiseDetailedSingle.getMIGO());
			zwdRow.createCell(18).setCellValue(circleWiseDetailedSingle.getMIRO());
			zwdRow.createCell(19).setCellValue(circleWiseDetailedSingle.getPaymentStatus());
		}
		
	}
}
