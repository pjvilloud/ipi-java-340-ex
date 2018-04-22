package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class  ExportPDFITextService {
    private double som;

    public void export(OutputStream os, FactureDTO facture) throws IOException, DocumentException {
Document document = new Document();
PdfWriter.getInstance(document,os);
document.open();

document.add(new Paragraph("Facture de "+facture.getClient().getPrenom()+" "+facture.getClient().getNom()+"\n"));

        document.add( Chunk.NEWLINE );
        document.add( Chunk.NEWLINE );
    PdfPTable table = new PdfPTable(3);

    PdfPCell c1 = new PdfPCell(new Phrase("Libelle"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Prix Unitaire"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Quantité"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    table.setHeaderRows(1);
    Double som= 0d;
    for(int i=0;i<facture.getLigneFactures().size();i++){

        table.addCell(facture.getLigneFactures().get(i).getDesignation());
        table.addCell(facture.getLigneFactures().get(i).getPrixUnitaire().toString());
        table.addCell(facture.getLigneFactures().get(i).getQuantite().toString());
        som+=facture.getLigneFactures().get(i).getPrixUnitaire()*facture.getLigneFactures().get(i).getQuantite();

    }
      Long som1=Math.round(som);
    table.addCell("Total de la facture");
    table.addCell(som1.toString());
    table.addCell("");

    /*
    table.addCell("1.1");
    table.addCell("1.2");
    table.addCell("2.1");
    table.addCell("2.2");
    table.addCell("2.3");*/
    document.add(table);
document.close();
    }
}
