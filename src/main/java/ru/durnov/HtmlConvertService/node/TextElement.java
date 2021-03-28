package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.*;

/**
 * Так получилось, что p и span у нас парсятся одинаково.
 * Поэтому, чтобы не вносить изменения сразу в оба класса,
 * для тегов p и span будем использовать этот класс.
 * Класс SpanElement объявляем пока deprecated.
 */
public class TextElement implements DocxElement {
    protected final Element element;
    protected final XWPFDocument document;
    protected final HtmlStyle htmlStyle;

    public TextElement(Element element) {
        this.element = element;
        this.document = new XWPFDocument();
        this.htmlStyle = new HtmlStyle(element.attributes());
    }

    public TextElement(Element element, XWPFDocument document) {
        this.element = element;
        this.document = document;
        this.htmlStyle = new HtmlStyle(element.attributes());
    }

    public TextElement(Element element, XWPFDocument document, HtmlStyle htmlStyle){
        this.element = element;
        this.document = document;
        this.htmlStyle = htmlStyle.withAttributes(element.attributes());
    }

    @Override
    public void addToXWPFDocument() {
        if (!element.ownText().equals("")){
            new SimplePElement(element, document, this.htmlStyle).addToXWPFDocument();
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
