package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import ru.durnov.HtmlConvertService.style.HtmlWidth;

/**
 * Настройка ширины столбца через ячейку в xlsx-документе.
 */
public class XlsxColumnWidth {
    private final HtmlWidth htmlWidth;
    private final XSSFCell xssfCell;
    public XlsxColumnWidth(XSSFCell xssfCell, HtmlWidth htmlWidth) {
        this.xssfCell = xssfCell;
        this.htmlWidth = htmlWidth;
    }

    public void setUpWidth(XSSFCellStyle xssfCellStyle) {
        if (this.htmlWidth.value() != 15) {
            xssfCellStyle.setWrapText(true);
            xssfCell.getSheet().setColumnWidth(xssfCell.getColumnIndex(), htmlWidth.value() * 256);
        }
    }
}
