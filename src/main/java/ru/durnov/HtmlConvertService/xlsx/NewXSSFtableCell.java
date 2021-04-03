package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import ru.durnov.HtmlConvertService.text.XlxsElement;

/**
 * Класс создает новую ячейку в XSSFRow по номеру столбца.
 */
public class NewXSSFtableCell implements XlxsElement {
    private final XSSFRow xssfRow;
    private final int columnNumber;

    public NewXSSFtableCell(XSSFRow xssfRow, int columnNumber) {
        this.xssfRow = xssfRow;
        this.columnNumber = columnNumber;
    }

    @Override
    public void addToXSSFWorkBook() {

    }

    public XSSFCell createCellByNumber() {
        /*XSSFCell xssfCell = xssfRow.getCell(columnNumber);
        if (xssfCell == null) return xssfRow.createCell(columnNumber);
        return xssfCell;*/
        //if (columnNumber == 0) return xssfRow.getCell(0);
        return xssfRow.createCell(columnNumber);
    }
}
