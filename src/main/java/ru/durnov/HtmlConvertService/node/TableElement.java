package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

public class TableElement implements DocxElement {
    private final Element element;
    private final XWPFDocument document;
    private final HtmlStyle htmlStyle;

    public TableElement(Element element, XWPFDocument document) {
        this.element = element;
        this.document = document;
        this.htmlStyle = new HtmlStyle(element.attributes());
    }

    public TableElement(Element element, XWPFDocument document, HtmlStyle htmlStyle) {
        this.element = element;
        this.document = document;
        this.htmlStyle = htmlStyle.withAttributes(element.attributes());
    }

    @Override
    public void addToXWPFDocument() {

    }
}
