package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontSize;

/**
 * Стиль для части строки в ячейке xlsx-документа с жирным шрифтом
 */
public class XSSFRichStringStrongStyle  extends XSSFRichStringStyle{

    public XSSFRichStringStrongStyle(Element element, XSSFCell xssfCell) {
        super(element, xssfCell);
    }

    @Override
    protected void setFontWeight(XSSFFont xssfFont) {
        xssfFont.setBold(true);
    }
}
