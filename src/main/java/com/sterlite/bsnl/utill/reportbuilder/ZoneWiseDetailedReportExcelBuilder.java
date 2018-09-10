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

public class ZoneWiseDetailedReportExcelBuilder extends AbstractXlsxView  {


	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		@SuppressWarnings("unchecked")
		  List<ZoneWiseDetailed> zoneWiseDetailedList = (List<ZoneWiseDetailed>) model.get("zwdList");
		
		Sheet sheet = workbook.createSheet("ZoneWiseDetailedReport");
//Phase	Zone Name	Circle Name	Circle Code	Location	SSA Code	BNG Type	Exist/New/Train	BNG ID	Site Survey	Site Ready
		//Material Delivery	Power On	NW Integration	AT	Commissioning	ATC	ERP PO	MIGO	MIRO	Payment Status
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Phase");
		header.createCell(1).setCellValue("Zone Name");
		header.createCell(2).setCellValue("Circle Name");
		header.createCell(3).setCellValue("Circle Code");
		header.createCell(4).setCellValue("Location");
		header.createCell(5).setCellValue("SSA Code");
		header.createCell(6).setCellValue("BNG Type");
		header.createCell(7).setCellValue("Exist/New/Train");
		header.createCell(8).setCellValue("BNG ID");
		header.createCell(9).setCellValue("Site Survey");
		header.createCell(10).setCellValue("Site Ready");
		header.createCell(11).setCellValue("Material Delivery");
		header.createCell(12).setCellValue("Power On");
		header.createCell(13).setCellValue("NW Integration");
		header.createCell(14).setCellValue("AT");
		header.createCell(15).setCellValue("Commissinong");
		header.createCell(16).setCellValue("ATC");
		header.createCell(17).setCellValue("ERP OP");
		header.createCell(18).setCellValue("MIGO");
		header.createCell(19).setCellValue("MIRO");
		header.createCell(20).setCellValue("Payment Status");
		
		int rowCount = 1;
		for (ZoneWiseDetailed zoneWiseDetailedSingle :zoneWiseDetailedList) {
			Row zwdRow = sheet.createRow(rowCount++);
			zwdRow.createCell(0).setCellValue(zoneWiseDetailedSingle.getPhase());
			zwdRow.createCell(1).setCellValue(zoneWiseDetailedSingle.getZoneName());
			zwdRow.createCell(2).setCellValue(zoneWiseDetailedSingle.getCircleName());
			zwdRow.createCell(3).setCellValue(zoneWiseDetailedSingle.getCircleCode());
			zwdRow.createCell(4).setCellValue(zoneWiseDetailedSingle.getLocation());
			zwdRow.createCell(5).setCellValue(zoneWiseDetailedSingle.getSSACode());
			zwdRow.createCell(6).setCellValue(zoneWiseDetailedSingle.getBNGType());
			zwdRow.createCell(7).setCellValue(zoneWiseDetailedSingle.getExistNewTrain());
			zwdRow.createCell(8).setCellValue(zoneWiseDetailedSingle.getBNGID());
			zwdRow.createCell(9).setCellValue(zoneWiseDetailedSingle.getSiteSurvey());
			zwdRow.createCell(10).setCellValue(zoneWiseDetailedSingle.getSiteReady());
			zwdRow.createCell(11).setCellValue(zoneWiseDetailedSingle.getMaterialDelivery());
			zwdRow.createCell(12).setCellValue(zoneWiseDetailedSingle.getPowerOn());
			zwdRow.createCell(13).setCellValue(zoneWiseDetailedSingle.getNWIntegration());
			zwdRow.createCell(14).setCellValue(zoneWiseDetailedSingle.getAT());
			zwdRow.createCell(15).setCellValue(zoneWiseDetailedSingle.getCommissioning());
			zwdRow.createCell(16).setCellValue(zoneWiseDetailedSingle.getATC());
			zwdRow.createCell(17).setCellValue(zoneWiseDetailedSingle.getERPPO());
			zwdRow.createCell(18).setCellValue(zoneWiseDetailedSingle.getMIGO());
			zwdRow.createCell(19).setCellValue(zoneWiseDetailedSingle.getMIRO());
			zwdRow.createCell(20).setCellValue(zoneWiseDetailedSingle.getPaymentStatus());
		}

		
	}
}
