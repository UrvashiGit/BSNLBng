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
import com.sterlite.bsnl.model.ZoneWiseDetailed;

public class CircleWiseDetailedReportPdfBuilder {
	
	public static ByteArrayInputStream generateReport(List<ZoneWiseDetailed> circleWiseDetailedList) {

        Document document = new Document(PageSize.A4.rotate(), 10f, 10f, 10f, 0f);
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Font headFont = FontFactory.getFont(FontFactory.HELVETICA);
        headFont.setSize(10);
        //Title
        Chunk chunk = new Chunk("Circle Wise Detailed Report", headFont);
        Chapter titleLine = new Chapter(new Paragraph(chunk), 1);
        titleLine.setNumberDepth(0);
        
        
        try {

            PdfPTable table = new PdfPTable(20);
            table.setWidthPercentage(100);

            //Phase	Circle Name	Circle Code	Location	SSA Code	BNG Type	Exist/New/Train	BNG ID	
            //Site Survey	Site Ready	Material Delivery	Power On	NW Integration	AT	Commissioning	ATC	ERP PO	MIGO	MIRO	Payment Status
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
            
            hcell = new PdfPCell(new Phrase("Location", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("SSA Code", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("BNG Type", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Exist/New/Train", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("BND ID", headFont));
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
            
            for (ZoneWiseDetailed circleWiseDetailed: circleWiseDetailedList) {
            	PdfPCell cell;
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getPhase()));
                table.addCell(cell);
                
              
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getCircleName()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getCircleCode()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getLocation()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getSSACode()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getBNGType()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getExistNewTrain()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getBNGID()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getSiteSurvey()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getSiteReady()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getMaterialDelivery()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getPowerOn()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getNWIntegration()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getAT()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getCommissioning()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getATC()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getERPPO()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getMIGO()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(circleWiseDetailed.getMIRO()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                

                cell = new PdfPCell(new Phrase(circleWiseDetailed.getPaymentStatus()));
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
