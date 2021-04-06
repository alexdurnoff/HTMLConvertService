package ru.durnov.HtmlConvertService.css;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.durnov.HtmlConvertService.style.*;
import ru.durnov.HtmlConvertService.table.XlsxCellStyle;
import ru.durnov.HtmlConvertService.xlsx.XlsxStyle;

import java.io.IOException;

/**
 * Класс будет возвращать XlsxStyle из файла. Инкапсулирует строку - путь к файлу.
 */
public class CssStyleFromHtml {

    private final String source;

    public CssStyleFromHtml(String source) {
        this.source = source;
    }

    public XlsxStyle xlsxStyle(XSSFWorkbook xssfWorkbook) throws IOException {
        HtmlFont htmlFont = new HtmlFontFromCSSStyle(source).font();
        HtmlAlignment htmlAlignment = new HtmlAlignmentFromCSSStyle(source).alignment();
        HtmlBackGround htmlBackGround = new HtmlBackGroundFromCSSStyle(source).backGround();
        HtmlWidth htmlWidth = new HtmlWidthFromCSSStyle(source).width();
        TableBorder tableBorder = new TableBorderFromCSSStyle(source).tableBorder();
        return new XlsxCellStyle(
                htmlFont,
                htmlAlignment,
                htmlBackGround,
                htmlWidth,
                tableBorder,
                xssfWorkbook
        );
    }
}
