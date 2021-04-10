package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.durnov.HtmlConvertService.table.HtmlTable;
import ru.durnov.HtmlConvertService.table.HtmlTableBody;

import java.util.Optional;

/**
 * Таблица в xlsx-документе
 */
public class XLSXTable implements XlxsElement {
    private final HtmlTable htmlTable;
    private final XSSFWorkbook xssfWorkbook;
    private final XlsxStyle xlsxStyle;

    public XLSXTable(HtmlTable htmlTable, XSSFWorkbook xssfWorkbook, XlsxStyle xlsxStyle) {
        this.htmlTable = htmlTable;
        this.xssfWorkbook = xssfWorkbook;
        this.xlsxStyle = xlsxStyle;
    }

    @Override
    public void addToXSSFWorkBook() {
        Optional<HtmlTableBody> optional = htmlTable.htmlBody();
        if (optional.isPresent()) {
            HtmlTableBody htmlTableBody = optional.get();
            new XlsxTableBody(
                    htmlTableBody,
                    xssfWorkbook,
                    this.xlsxStyle
            ).addToXSSFWorkBook();
        }

    }
}
