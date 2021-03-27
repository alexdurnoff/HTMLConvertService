package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class ElementFactory {
    private final Element element;
    private final XWPFDocument document;

    public ElementFactory(Element element, XWPFDocument document) {
        this.element = element;
        this.document = document;
    }

    public ElementFactory(Node node, XWPFDocument document){
        if (node.getClass() != Element.class) throw new IllegalArgumentException("node must be element");
        this.element = (Element) node;
        this.document = document;
    }


    public HtmlElement elementByName(){
        if (element.nodeName().equals("p")) return new PElement(element, document);
        if (element.nodeName().equals("span")) return new SpanElement(element, document);
        if (element.nodeName().equals("td")) return new TableElement(element, document);
        return new EmptyElement();
    }
}
