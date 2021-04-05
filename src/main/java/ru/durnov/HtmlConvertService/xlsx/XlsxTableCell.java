package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import ru.durnov.HtmlConvertService.table.HtmlTableCell;
import ru.durnov.HtmlConvertService.text.XlxsElement;

public class XlsxTableCell implements XlxsElement {
    private final HtmlTableCell htmlTableCell;
    private final XSSFRow xssfRow;
    private final CurrentColumnNumber columnNumber;
    private final CurrentRowNumber rowNumber;
    private final XlsxStyle xlsxStyle;


    public XlsxTableCell(HtmlTableCell htmlTableCell,
                         XSSFRow xssfRow,
                         CurrentColumnNumber columnNumber,
                         CurrentRowNumber rowNumber,
                         XlsxStyle xlsxStyle) {
        this.htmlTableCell = htmlTableCell;
        this.xssfRow = xssfRow;
        this.columnNumber = columnNumber;
        this.rowNumber = rowNumber;
        this.xlsxStyle = xlsxStyle;
    }

    @Override
    public void addToXSSFWorkBook() {
        XSSFCell xssfCell = xssfRow.createCell(columnNumber.columnNumber());
        int collspan = htmlTableCell
                .docxTableCellStyle()
                .tableCellCollSpan()
                .collspan();
        if (collspan > 1){
            int firstRow = xssfRow.getRowNum();
            int firstColumn = xssfCell.getColumnIndex();
            int lastColumn = firstColumn + collspan - 1;
            xssfRow.getSheet().addMergedRegion(
                    new CellRangeAddress(
                            firstRow,
                            firstRow,
                            firstColumn,
                            lastColumn
                    )
            );
            columnNumber.increaseColumnNumber(collspan);
        } else {
            columnNumber.increaseColumnNumber(1);
        }
        htmlTableCell.addTextToXSSFCell(xssfCell,xlsxStyle);
    }
}
