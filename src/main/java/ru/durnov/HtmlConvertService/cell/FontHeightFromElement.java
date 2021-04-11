package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontSize;

/**
 * Либо достает из элемента новую высоту шрифта,
 * либо возвращает стурую.
 */
public class FontHeightFromElement {
    private final Element element;
    private final XSSFFont xssfFont;

    public FontHeightFromElement(Element element, XSSFFont xssfFont) {
        this.element = element;
        this.xssfFont = xssfFont;
    }

    public int height(){
        if (element.outerHtml().contains("font-size")){
            if (element.nodeName().equals("small")) return new FontSize(element.attributes()).value()-2;
            return new FontSize(element.attributes()).value();
        }
        return xssfFont.getFontHeight();
    }
}
