package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;

public class SpanElement implements HtmlElement {
    private final Element element;
    private final XWPFDocument document;


    public SpanElement(Element element, XWPFDocument document) {
        this.element = element;
        this.document = document;
    }

    @Override
    public void addToXWPFDocument() {
        if (!element.ownText().equals("")){
            new SimplePElement(element, document).addToXWPFDocument();
        }
    }
}
