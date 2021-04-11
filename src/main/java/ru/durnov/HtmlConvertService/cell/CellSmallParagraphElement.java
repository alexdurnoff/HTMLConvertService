package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jsoup.nodes.Element;

/**
 * Класс отвечает за тэг <small></small>
 * Все то же самое, что и CellTextParagraphElement,
 * только уменьшает шрифт действующей ячейки.
 */
public class CellSmallParagraphElement extends CellTextParagraphElement{
    public CellSmallParagraphElement(Element element, XSSFCell xssfCell) {
        super(element, xssfCell);
    }

    @Override
    protected void setFontToXSSFRichTextString() {
        new XSSFRichStringSmallStyle(element, xssfCell).applyToXSSFRichTextString();
    }
}
