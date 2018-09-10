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

public class CircleWiseSummeryReportPdfBuilder {
	
	public static ByteArrayInputStream generateReport(List<SummaryModel> circleWiseSummaryList) {

        Document document = new Document(PageSize.A4.rotate(), 10f, 10f, 10f, 0f);
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Font headFont = FontFactory.getFont(FontFactory.HELVETICA);
        headFont.setSize(12);
        //Title
        Chunk chunk = new Chunk("Circle Wise Summery Report", headFont);
        Chapter titleLine = new Chapter(new Paragraph(chunk), 1);
        titleLine.setNumberDepth(0);
        
        
        try {

            PdfPTable table = new PdfPTable(16);
            table.setWidthPercentage(100);

          //Phase	Circle Name	Circle Code	Total BNG	Site Survey	Site Ready	Material Delivery
            //Power On	NW Integration	AT	Commissinong	ATC	ERP PO	MIGO	MIRO	Payment Status

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Phase", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Circle Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Circle Code", headFont));
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
            
            for (SummaryModel singleCircleWiseSummary: circleWiseSummaryList) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getPhase()));
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getCircleName()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getCircleCode()));
                cell.setPaddingLeft(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getTotalBng()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getSiteSurvey()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getSiteReady()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getMaterialDelivery()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getPowerOn()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getNWIntegration()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getAT()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getCommissioning()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getATC()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getERPPO()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getMIGO()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getMIRO()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                

                cell = new PdfPCell(new Phrase(singleCircleWiseSummary.getPaymentStatus()));
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
