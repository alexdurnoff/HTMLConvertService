package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;

public class TableElement implements HtmlElement {
    private final Element element;
    private final XWPFDocument document;

    public TableElement(Element element, XWPFDocument document) {
        this.element = element;
        this.document = document;
    }

    @Override
    public void addToXWPFDocument() {

    }
}
