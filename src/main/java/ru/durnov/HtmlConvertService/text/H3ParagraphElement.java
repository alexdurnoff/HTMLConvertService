package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.H2Style;
import ru.durnov.HtmlConvertService.style.H3Style;

/**
 * Элемент заголовка h3.
 * По умолчанию у него будет 20-й шрифт.
 * Пока что отличается от TextElement только шрифтом.
 */
public class H3ParagraphElement extends TextParagraphElement {

    public H3ParagraphElement(Element element, XWPFDocument document) {
        super(element, document, new H3Style().withAttributes(element.attributes()));
    }
}

