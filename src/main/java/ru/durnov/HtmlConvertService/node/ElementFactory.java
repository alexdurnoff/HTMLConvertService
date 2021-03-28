package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.docx.DocxTable;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

public class ElementFactory {
    private final Element element;
    private final XWPFDocument document;
    private final HtmlStyle htmlStyle;

    public ElementFactory(Element element, XWPFDocument document) {
        this.element = element;
        this.document = document;
        this.htmlStyle = new HtmlStyle(element.attributes());
    }

    public ElementFactory(Node node, XWPFDocument document){
        if (node.getClass() != Element.class) throw new IllegalArgumentException("node must be element");
        this.element = (Element) node;
        this.document = document;
        this.htmlStyle = new HtmlStyle(element.attributes());
    }

    public ElementFactory(Node node, XWPFDocument document, HtmlStyle htmlStyle){
        if (node.getClass() != Element.class) throw new IllegalArgumentException("node must be element");
        this.element = (Element) node;
        this.document = document;
        this.htmlStyle = htmlStyle.withAttributes(element.attributes());
    }

    public ElementFactory(Element element, XWPFDocument document, HtmlStyle htmlStyle1){
        this.element = element;
        this.document = document;
        this.htmlStyle = htmlStyle1.withAttributes(element.attributes());
    }


    public DocxElement elementByName(){
        if (element.nodeName().equals("p") || element.nodeName().equals("span")){
            return new TextElement(element, document, htmlStyle);
        }
        if (element.nodeName().equals("br")) return new BRElement(element, document, htmlStyle);
        if (element.nodeName().equals("td")) return new TableElement(element, document, htmlStyle);
        if (element.nodeName().equals("h2")) return new H2Element(element,document);
        if (element.nodeName().equals("td")) return new DocxTable(new HtmlTable(element,htmlStyle),document);
        return new EmptyElement();
    }
}
