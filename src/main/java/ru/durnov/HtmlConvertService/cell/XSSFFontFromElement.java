package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;

/**
 * Класс возвращает либо старый шрифт,
 * либо новый, если внутри элемента есть настройки шрифта.
 */
public class XSSFFontFromElement {
    private final Element element;
    private final XSSFFont xssfFont;
    private final XSSFCell xssfCell;

    public XSSFFontFromElement(Element element, XSSFFont xssfFont, XSSFCell xssfCell) {
        this.element = element;
        this.xssfFont = xssfFont;
        this.xssfCell = xssfCell;
    }

    public XSSFFont xssfFont(){
        if (element.outerHtml().contains("font-")){
            XSSFFont font = xssfCell.getSheet().getWorkbook().createFont();
            font.setFontHeight(new FontSize(element.attributes()).value());
            if (new FontWeight(element.attributes()).value().equals("bold")) font.setBold(true);
            return font;
        }
        return this.xssfFont;
    }
}
