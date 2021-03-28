package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.H2Style;

/**
 * Элемент заголовка h2.
 * По умолчанию у него будет 24-й шрифт.
 * Пока что отличается от TextElement только шрифтом.
 */
public class H2Element extends TextElement {

    public H2Element(Element element, XWPFDocument document) {
        super(element, document, new H2Style().withAttributes(element.attributes()));
    }
}

