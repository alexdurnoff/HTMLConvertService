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


    public XlsxTableCell(HtmlTableCell htmlTableCell, XSSFRow xssfRow, CurrentColumnNumber columnNumber) {
        this.htmlTableCell = htmlTableCell;
        this.xssfRow = xssfRow;
        this.columnNumber = columnNumber;
    }

    @Override
    public void addToXSSFWorkBook() {
        //XSSFCell xssfCell = new NewXSSFtableCell(xssfRow,cellNumber).createCellByNumber();
        XSSFCell xssfCell = xssfRow.createCell(columnNumber.columnNumber());
        int span = htmlTableCell
                .docxTableCellStyle()
                .tableCellCollSpan()
                .collspan();
        if (span > 1){
            int firstRow = xssfRow.getRowNum();
            int firstColumn = xssfCell.getColumnIndex();
            int lastColumn = firstColumn + span - 1;
            xssfRow.getSheet().addMergedRegion(
                    new CellRangeAddress(
                            firstRow,
                            firstRow,
                            firstColumn,
                            lastColumn
                    )
            );
            columnNumber.increaseColumnNumber(span);
        } else {
            columnNumber.increaseColumnNumber(1);
        }
        htmlTableCell.addTextToXSSFCell(xssfCell);
    }
}
