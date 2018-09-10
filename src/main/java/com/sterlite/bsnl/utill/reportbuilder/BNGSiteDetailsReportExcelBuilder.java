package com.sterlite.bsnl.utill.reportbuilder;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.Book;

public class BNGSiteDetailsReportExcelBuilder extends AbstractXlsxView  {


	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		@SuppressWarnings("unchecked")
		  List<BngMaster> bngMasterList = (List<BngMaster>) model.get("bngList");
		
		Sheet sheet = workbook.createSheet("BNGSiteDetailsReport");
		//Phase	Circle Name	Circle Code	Total BNG	Site Survey	Site Ready	Material Delivery	Power On	NW Integration	AT	Commissinong	ATC	ERP PO	MIGO	MIRO	Payment Status
		Row header = sheet.createRow(0);
		
		header.createCell(0).setCellValue("Phase");
		header.createCell(1).setCellValue("BNG ID");
		header.createCell(2).setCellValue("Zone Name");
		header.createCell(3).setCellValue("Circle Name");
		header.createCell(4).setCellValue("Circle Code");
		header.createCell(5).setCellValue("Location");
		header.createCell(6).setCellValue("SSA Code");
		header.createCell(7).setCellValue("BNG Type");
		header.createCell(8).setCellValue("Exist/New/Train");
		header.createCell(9).setCellValue("Site Name & Location");
		header.createCell(10).setCellValue("Circle Coordinator Details");
		header.createCell(11).setCellValue("Consignee Detail");
		header.createCell(12).setCellValue("Site Address");
		header.createCell(13).setCellValue("Site Person Name");
		header.createCell(14).setCellValue("Site Contact No.");
		header.createCell(15).setCellValue("GSTIN");
		

		
		int rowCount = 1;
		for (BngMaster bngMaster :bngMasterList) {
			Row bngMasterRow = sheet.createRow(rowCount++);
			bngMasterRow.createCell(0).setCellValue(bngMaster.getPhase());
			bngMasterRow.createCell(1).setCellValue(bngMaster.getId());
			bngMasterRow.createCell(2).setCellValue(bngMaster.getZoneName());
			bngMasterRow.createCell(3).setCellValue(bngMaster.getCircleName());
			bngMasterRow.createCell(4).setCellValue(bngMaster.getCircleCode());
			bngMasterRow.createCell(5).setCellValue(bngMaster.getLocation());
			bngMasterRow.createCell(6).setCellValue(bngMaster.getSsaCode());
			bngMasterRow.createCell(7).setCellValue(bngMaster.getBngType());
			bngMasterRow.createCell(8).setCellValue(bngMaster.getExitNewTrain());
			bngMasterRow.createCell(9).setCellValue(bngMaster.getSiteNameLocation());
			bngMasterRow.createCell(10).setCellValue(bngMaster.getCircleCoordinatorDet());
			bngMasterRow.createCell(11).setCellValue(bngMaster.getConsigneeDet());
			bngMasterRow.createCell(12).setCellValue(bngMaster.getSiteAddress());
			bngMasterRow.createCell(13).setCellValue(bngMaster.getSitePersonDet());
			bngMasterRow.createCell(14).setCellValue(bngMaster.getSiteContactNo());
			bngMasterRow.createCell(15).setCellValue(bngMaster.getGstin());
			
		}

		
	}
}
