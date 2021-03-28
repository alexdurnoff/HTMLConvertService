package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

/**
 * По сути класс оказался таким же, как и класс для тэга p.
 * Поэтому его пока не используем.
 */
@Deprecated
public class SpanElement implements HtmlElement {
    private final Element element;
    private final XWPFDocument document;
    private final HtmlStyle htmlStyle;


    public SpanElement(Element element, XWPFDocument document) {
        this.element = element;
        this.document = document;
        this.htmlStyle = new HtmlStyle(element.attributes());
    }

    public SpanElement(Element element, XWPFDocument document, HtmlStyle htmlStyle) {
        System.out.println(htmlStyle);
        this.element = element;
        this.document = document;
        this.htmlStyle = htmlStyle.withAttributes(element.attributes());
    }

    @Override
    public void addToXWPFDocument() {
        if (!element.ownText().equals("")){
            new SimplePElement(element, document, htmlStyle).addToXWPFDocument();
        }
        element.childNodes().forEach(node -> {
            if (node.getClass() == Element.class){
                new ElementFactory(
                        node,
                        document,
                        htmlStyle
                )
                        .elementByName()
                        .addToXWPFDocument();
            }
        });
    }
}
