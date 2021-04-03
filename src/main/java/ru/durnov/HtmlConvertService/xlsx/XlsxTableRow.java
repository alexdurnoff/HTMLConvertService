package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import ru.durnov.HtmlConvertService.docx.DocxTableCell;
import ru.durnov.HtmlConvertService.table.HtmlTableCell;
import ru.durnov.HtmlConvertService.table.HtmlTableRow;
import ru.durnov.HtmlConvertService.table.XlsxCellStyle;
import ru.durnov.HtmlConvertService.text.XlxsElement;

import java.util.List;

public class XlsxTableRow implements XlxsElement {
    private final HtmlTableRow htmlTableRow;
    private final XSSFSheet xssfSheet;
    private final int rowNumber;
    private final XlsxStyle xlsxStyle;

    public XlsxTableRow(HtmlTableRow htmlTableRow, XSSFSheet xssfSheet, int rowNumber, XlsxStyle xlsxStyle) {
        this.htmlTableRow = htmlTableRow;
        this.xssfSheet = xssfSheet;
        this.rowNumber = rowNumber;
        this.xlsxStyle = xlsxStyle;
    }

    @Override
    public void addToXSSFWorkBook() {
        XSSFRow xssfRow = new NewXSSFRow(xssfSheet, rowNumber).createRowByNumber();
        xlsxStyle.applyToXlsxTableRow(xssfRow);
        List<HtmlTableCell> htmlTableCells = htmlTableRow.htmlTableCellList();
        CurrentColumnNumber columnNumber = new CurrentColumnNumber();
        for (HtmlTableCell htmlTableCell : htmlTableCells) {
            new XlsxTableCell(
                    htmlTableCell,
                    xssfRow,
                    columnNumber
            ).addToXSSFWorkBook();
        }
    }
}
