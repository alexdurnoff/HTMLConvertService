package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontWeight;

public class FontWeightFromElement {
    private final Element element;
    private final XSSFFont xssfFont;

    public FontWeightFromElement(Element element, XSSFFont xssfFont) {
        this.element = element;
        this.xssfFont = xssfFont;
    }

    public boolean weight(){
        if (element.nodeName().equals("b")) return true;
        if (element.nodeName().equals("strong")) return true;
        return new FontWeight(element.attributes()).value().contains("bold");
    }
}
