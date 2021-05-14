package ru.durnov.HtmlConvertService.style.border;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;

/**
 * Параметры обрамления xlsx-таблицы,
 * ячеек, строк. Инкапсулирует HtmlTableBorder.
 * Настраивает стиль ячейки в xlsx-документе.
 */
public class XlsxTableBorder {
    private final HtmlTableBorder htmlTableBorder;

    public XlsxTableBorder(HtmlTableBorder htmlTableBorder) {
        this.htmlTableBorder = htmlTableBorder;
    }

    public void setupBorders(XSSFCellStyle xssfCellStyle){
        if (htmlTableBorder.borderStyle() != BorderStyle.NONE) {
            xssfCellStyle.setBorderLeft(htmlTableBorder.borderStyle());
            xssfCellStyle.setBorderRight(htmlTableBorder.borderStyle());
            xssfCellStyle.setBorderTop(htmlTableBorder.borderStyle());
            xssfCellStyle.setBorderBottom(htmlTableBorder.borderStyle());
        }
        if (htmlTableBorder.borderStyle() != BorderStyle.NONE) {
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, htmlTableBorder.xssfColor());
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.LEFT, htmlTableBorder.xssfColor());
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, htmlTableBorder.xssfColor());
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.TOP, htmlTableBorder.xssfColor());
        }

    }
}
