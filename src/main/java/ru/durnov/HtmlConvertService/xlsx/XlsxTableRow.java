package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import ru.durnov.HtmlConvertService.table.HtmlTableCell;
import ru.durnov.HtmlConvertService.table.HtmlTableRow;

import java.util.List;

public class XlsxTableRow implements XlxsElement {
    private final HtmlTableRow htmlTableRow;
    private final XSSFSheet xssfSheet;
    private final CurrentRowNumber rowNumber;
    private final XlsxStyle xlsxStyle;

    public XlsxTableRow(HtmlTableRow htmlTableRow, XSSFSheet xssfSheet, CurrentRowNumber rowNumber, XlsxStyle xlsxStyle) {
        this.htmlTableRow = htmlTableRow;
        this.xssfSheet = xssfSheet;
        this.rowNumber = rowNumber;
        this.xlsxStyle = xlsxStyle;
    }

    @Override
    public void addToXSSFWorkBook() {
        XSSFRow xssfRow = new NewXSSFRow(xssfSheet, rowNumber.rowNumber()).createRowByNumber();
        this.xlsxStyle.applyToXlsxTableRow(xssfRow);
        rowNumber.increaseRowNumber(1);
        List<HtmlTableCell> htmlTableCells = htmlTableRow.htmlTableCellList();
        CurrentColumnNumber columnNumber = new CurrentColumnNumber();
        for (HtmlTableCell htmlTableCell : htmlTableCells) {
            new XlsxTableCell(
                    htmlTableCell,
                    xssfRow,
                    columnNumber,
                    rowNumber,
                    xlsxStyle
            ).addToXSSFWorkBook();
        }
    }
}
