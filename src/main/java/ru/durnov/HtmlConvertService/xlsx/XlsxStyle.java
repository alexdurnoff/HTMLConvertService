package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;

public interface XlsxStyle extends Style {
    void applyToXlsxTableCell(XSSFCell xssfCell);
    void applyToXlsxSheet(XSSFSheet xssfSheet);
    void applyToXlsxTableRow(XSSFRow xssfRow);
    XlsxStyle withStyle(XlsxStyle xlsxStyle);

}
