package com.sterlite.bsnl.utill.reportbuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sterlite.bsnl.entity.Book;
import com.sterlite.bsnl.model.SummaryModel;

public class ZoneWiseSummeryReportPdfBuilder {
	
	public static ByteArrayInputStream generateReport(List<SummaryModel> zoneWiseSummaryList) {

        Document document = new Document(PageSize.A4.rotate(), 10f, 10f, 10f, 0f);
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Font headFont = FontFactory.getFont(FontFactory.HELVETICA);
        headFont.setSize(10);
        //Title
        Chunk chunk = new Chunk("Zone Wise Summery Report", headFont);
        Chapter titleLine = new Chapter(new Paragraph(chunk), 1);
        titleLine.setNumberDepth(0);
        
        
        try {

            PdfPTable table = new PdfPTable(15);
            table.setWidthPercentage(100);

//Phase	Zone Name	Total BNG	Site Survey Site Ready	Material Delivery	Power On	NW Integration	
            //AT	Commissinong	ATC	ERP PO	MIGO	MIRO	Payment Status

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Phase", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Zone Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Total BNG", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Site Survey", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Site Ready", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Material Delivery", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Power On", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("NW Integration", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("AT", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Commissinong", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("ATC", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("ERP PO", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("MIGO", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("MIRO", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            
            hcell = new PdfPCell(new Phrase("Payment Status", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            for (SummaryModel singleZoneWiseSummary: zoneWiseSummaryList) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getPhase()));
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getZoneName()));
                cell.setPaddingLeft(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getTotalBng()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getSiteSurvey()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getSiteReady()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getMaterialDelivery()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getPowerOn()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getNWIntegration()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getAT()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getCommissioning()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getATC()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getERPPO()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getMIGO()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getMIRO()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                

                cell = new PdfPCell(new Phrase(singleZoneWiseSummary.getPaymentStatus()));
                cell.setPaddingRight(5);
                table.addCell(cell);
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(titleLine);
            document.add( Chunk.NEWLINE );
            document.add(table);
            
            document.close();
            
        } catch (DocumentException ex) {
        	ex.printStackTrace();
        
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
	
}
