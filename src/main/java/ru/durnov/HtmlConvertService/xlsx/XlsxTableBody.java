package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.durnov.HtmlConvertService.table.HtmlTableBody;
import ru.durnov.HtmlConvertService.text.XlxsElement;

public class XlsxTableBody implements XlxsElement {
    public XlsxTableBody(HtmlTableBody htmlTableBody, XSSFWorkbook xssfWorkbook, XlsxStyle xlsxStyle) {
    }

    @Override
    public void addToXSSFWorkBook() {

    }
}
