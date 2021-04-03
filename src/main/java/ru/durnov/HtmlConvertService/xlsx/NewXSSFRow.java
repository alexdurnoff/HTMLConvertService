package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * Класс для создания строки в листе xlsx-документа. Нужен,
 * поскольку лист создается изначально с одной строкой
 * и одной ячейкой в строке. Если в листе одна строка,
 * то класс возвращает эту строку. В противном случае создает новую строку.
 */
public class NewXSSFRow {
    private final XSSFSheet xssfSheet;
    private final int rowNumber;

    public NewXSSFRow(XSSFSheet xssfSheet, int rowNumber) {
        this.xssfSheet = xssfSheet;
        this.rowNumber = rowNumber;
    }

    public XSSFRow createRowByNumber() {
        XSSFRow row = xssfSheet.getRow(rowNumber);
        if (row == null) return xssfSheet.createRow(rowNumber);
        return row;
    }
}
