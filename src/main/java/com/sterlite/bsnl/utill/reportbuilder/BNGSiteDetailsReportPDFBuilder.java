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
import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.Book;

public class BNGSiteDetailsReportPDFBuilder {
	
	public static ByteArrayInputStream generateReport(List<BngMaster> bngMasterList) {

        Document document = new Document(PageSize.A4.rotate(), 10f, 10f, 10f, 0f);
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Font headFont = FontFactory.getFont(FontFactory.HELVETICA);
        headFont.setSize(10);
        //Title
        Chunk chunk = new Chunk("BNG Site Details", headFont);
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
            
            hcell = new PdfPCell(new Phrase("BNG ID", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Zone Name", headFont));
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
            
            hcell = new PdfPCell(new Phrase("Site Name & Location", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Circle Coordinator Details", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Consignee Detail", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Site Address", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Site Person Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Site Contact No.", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("GSTIN", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
          
            
            for (BngMaster bngMaster: bngMasterList) {

            	 System.out.println("Inside PDF : " +bngMaster.getId() );
                PdfPCell cell;

                cell = new PdfPCell(new Phrase(bngMaster.getPhase()));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(bngMaster.getId()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getZoneName()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getCircleName()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getCircleCode()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getLocation()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getSsaCode()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getBngType()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getExitNewTrain()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getSiteNameLocation()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getCircleCoordinatorDet()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getConsigneeDet()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getSiteAddress()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getSitePersonDet()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getSiteContactNo()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bngMaster.getGstin()));
                cell.setPaddingLeft(5);
                table.addCell(cell);
                
                

               /* cell = new PdfPCell(new Phrase(book.getPublication()));
               // cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
               // cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);*/
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
