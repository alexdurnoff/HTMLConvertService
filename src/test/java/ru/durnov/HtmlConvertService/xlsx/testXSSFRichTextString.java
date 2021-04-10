package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.*;
import org.junit.jupiter.api.Test;

public class testXSSFRichTextString {

    @Test
    public void test1(){
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet();
        XSSFRow xssfRow = xssfSheet.createRow(1);
        XSSFCell xssfCell = xssfRow.createCell(1);
        XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
        xssfRichTextString.append("Один");
        System.out.println(xssfRichTextString.getString());
        xssfCell.setCellValue(xssfRichTextString.getString());
        System.out.println(xssfCell.getStringCellValue());
        System.out.println(xssfCell.getRichStringCellValue().getString());
        //Вывод: вызов метода getRichStringCellValue() каждый раз выдает новую строку.
    }
}
