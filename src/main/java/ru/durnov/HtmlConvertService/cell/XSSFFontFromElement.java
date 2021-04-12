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
            font.setFontHeight(new FontHeightFromElement(element, xssfFont).height());
            font.setBold(new FontWeightFromElement(element, xssfFont).weight());
            if (element.nodeName().equals("b") || element.nodeName().equals("strong")) font.setBold(true);
            return font;
        }
        if (element.nodeName().equals("b") || element.nodeName().equals("strong")) this.xssfFont.setBold(true);
        return this.xssfFont;
    }
}
