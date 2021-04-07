package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.docx.DocxParagraphTable;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;
import ru.durnov.HtmlConvertService.table.HtmlTable;

public class ElementFactory {
    private final Element element;
    private final XWPFDocument document;
    private final Style htmlStyle;

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

    public ElementFactory(Node node, XWPFDocument document, Style htmlStyle){
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


    public DocxParagraphElement elementByName(){
        if (element.nodeName().equals("p") || element.nodeName().equals("span") || element.nodeName().equals("label")){
            return new TextParagraphElement(element, document, htmlStyle);
        }
        if (element.nodeName().equals("br")) return new BRParagraphElement(element, document, htmlStyle);
        if (element.nodeName().equals("h2")) return new H2ParagraphElement(element,document);
        if (element.nodeName().equals("table")) {
            return new DocxParagraphTable(
                    new HtmlTable(element),
                    document);
        }
        if (element.nodeName().equals("strong")) return new StrongParagraphElement(element,document,htmlStyle);
        return new EmptyParagraphElement();
    }
}
