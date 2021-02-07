package com.example.armstest.xlsx;

import com.example.armstest.Demand;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelGeneration {
    public static ByteArrayInputStream demandExcel(List<Demand> customers) throws IOException {
        String[] COLUMNs = {"Номер заявки", "Описание","Отдел", "Фамилия", "Время подачи","Статус заявки"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ){
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Demand");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }
            // CellStyle for Age
            CellStyle ageCellStyle = workbook.createCellStyle();
            ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

            int rowIdx = 1;
            for (Demand demand : customers) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(demand.getId());
                row.createCell(1).setCellValue(demand.getDemand_desc());
                row.createCell(2).setCellValue(demand.getOffice());
                row.createCell(3).setCellValue(demand.getUser());
                row.createCell(4).setCellValue(demand.getTime().toString());
                row.createCell(5).setCellValue(demand.getAccepted());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
