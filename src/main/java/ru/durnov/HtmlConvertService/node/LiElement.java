package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

public class LiElement implements HtmlElement{
    private final int number;
    private final Element element;
    private final XWPFDocument xwpfDocument;
    private final HtmlStyle htmlStyle;

    public LiElement(int number, Element element, XWPFDocument xwpfDocument, HtmlStyle htmlStyle) {
        this.number = number;
        this.element = element;
        this.xwpfDocument = xwpfDocument;
        this.htmlStyle = htmlStyle;
    }

    @Override
    public void addToXWPFDocument() {

    }
}
