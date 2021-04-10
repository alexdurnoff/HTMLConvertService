package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.durnov.HtmlConvertService.table.HtmlTableBody;
import ru.durnov.HtmlConvertService.table.HtmlTableRow;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Тело таблицы в xlsx-документе
 */
public class XlsxTableBody implements XlxsElement {
    private final HtmlTableBody htmlTableBody;
    private final XSSFWorkbook xssfWorkbook;
    private final XlsxStyle xlsxStyle;
    private final CurrentRowNumber currentRowNumber;

    public XlsxTableBody(HtmlTableBody htmlTableBody, XSSFWorkbook xssfWorkbook, XlsxStyle xlsxStyle) {
        this.htmlTableBody = htmlTableBody;
        this.xssfWorkbook = xssfWorkbook;
        this.xlsxStyle = xlsxStyle;
        this.currentRowNumber = new CurrentRowNumber();
    }


    @Override
    public void addToXSSFWorkBook() {
        XSSFSheet xssfSheet = xssfWorkbook.createSheet();
        this.xlsxStyle.applyToXlsxSheet(xssfSheet);
        List<HtmlTableRow> htmlTableRows = this.htmlTableBody
                .htmlTableRowsList()
                .stream()
                .filter(htmlTableRow -> (!htmlTableRow.isBorderRow()))
                .collect(Collectors.toList());
        int rowNumber = 0;
        for (HtmlTableRow htmlTableRow : htmlTableRows) {
            new XlsxTableRow(
                    htmlTableRow,
                    xssfSheet,
                    currentRowNumber,
                    xlsxStyle
            ).addToXSSFWorkBook();
            rowNumber++;
        }
    }
}
