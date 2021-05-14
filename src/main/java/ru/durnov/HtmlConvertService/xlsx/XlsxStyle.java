package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.Style;
import ru.durnov.HtmlConvertService.style.border.HtmlTableBorder;

public interface XlsxStyle extends Style {
    void applyToXlsxTableCell(XSSFCell xssfCell);
    void applyToXlsxSheet(XSSFSheet xssfSheet);
    void applyToXlsxTableRow(XSSFRow xssfRow);

    @Override
    XlsxStyle withAttributes(Attributes attributes);

    XlsxStyle withStyle(XlsxStyle xlsxStyle);

    XlsxStyle withTableBorder(HtmlTableBorder htmlTableBorder);
}
