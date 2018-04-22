package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class ExportXLSXService {
    private static final int HEADER_SIZE = 1;

    public void export (OutputStream os, List<ClientDTO> clients) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("clients");



        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nom");
        header.createCell(1).setCellValue("Prénom");




        for(int i=1;i<=clients.size();i++){
            Row line1=sheet.createRow(i);
            line1.createCell(0).setCellValue(clients.get(i-1).getNom());
            line1.createCell(1).setCellValue(clients.get(i-1).getPrenom());
        }

        //ou
       /*for(int index=0; index<clients.size();index++){
           XSSFRow row1=sheet.createRow(index+ HEADER_SIZE);
        }*/
        workbook.write(os);
        workbook.close();
    }


    public void exportFactures(OutputStream os, List<FactureDTO> factures) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();



        for (FactureDTO facture : factures) {

            XSSFSheet sheet = workbook.createSheet("Facture N° " + facture.getId().toString());


            Double totalGlobal = 0d;
            Double totalLigne = 0d;
            // Création des header pour chaque onglet
            int rowNum = 0;
            Row rowHeader = sheet.createRow(rowNum);
            Cell cellDesignationHeader = rowHeader.createCell(0);
            Cell cellQteHeader = rowHeader.createCell(1);
            Cell cellPuHeader = rowHeader.createCell(2);
            Cell cellPrixLigneHeader = rowHeader.createCell(3);
            cellDesignationHeader.setCellValue("Designation");
            cellPuHeader.setCellValue("Quantité");
            cellQteHeader.setCellValue("PU");
            cellPrixLigneHeader.setCellValue("Sous-total");
            List<Cell> cellsBody = new ArrayList<>();
            cellsBody.add(cellDesignationHeader);
            cellsBody.add(cellQteHeader);
            cellsBody.add(cellPuHeader);
            cellsBody.add(cellPrixLigneHeader);
            rowNum++;


            List<LigneFactureDTO> lignesFacture = facture.getLigneFactures();


            for (LigneFactureDTO ligneFacture : lignesFacture) {

                Row rowBody = sheet.createRow(rowNum++);
                // Boucle sur les cellules requises
                for (int index = 0; index < cellsBody.size(); index++) {
                    // Calcul du total par ligne
                    totalLigne = ligneFacture.getPrixUnitaire() * ligneFacture.getQuantite();
                    // Création des cellules
                    Cell cells = rowBody.createCell(index);

                    // selon l'index, on récupère la valeur de ligneFacture
                    if (index == 0) {
                        cells.setCellValue(ligneFacture.getDesignation());
                    }

                    if (index == 1) {
                        cells.setCellValue(ligneFacture.getQuantite());
                    }

                    if (index == 2) {
                        cells.setCellValue(ligneFacture.getPrixUnitaire());
                    }

                    if (index == 3) {
                        cells.setCellValue(totalLigne);
                    }
                }
                totalGlobal += totalLigne;

            }

            // Création d'une nouvelle ligne pour le total
            Row rowTotal = sheet.createRow(rowNum++);
            Cell cellTotalLibelle = rowTotal.createCell(2);
            Cell cellTotalValue = rowTotal.createCell(3);

            cellTotalLibelle.setCellValue("Total");
            cellTotalValue.setCellValue(String.valueOf(totalGlobal));
        }
        workbook.write(os);
        workbook.close();
    }
}
