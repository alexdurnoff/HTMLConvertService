package ru.durnov.HtmlConvertService.cell;

import org.jsoup.nodes.Element;

public class OwnTextFromElement {
    private final Element element;

    public OwnTextFromElement(Element element) {
        this.element = element;
    }
    public String text(){
        if (element.nodeName().equals("br")) return "\n";
        return element.ownText();
    }
}
