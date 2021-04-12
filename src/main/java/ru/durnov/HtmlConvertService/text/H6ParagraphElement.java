package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.H2Style;
import ru.durnov.HtmlConvertService.style.H6Style;

/**
 * Элемент заголовка h6.
 * По умолчанию у него будет 8-й шрифт.
 * Пока что отличается от TextElement только шрифтом.
 */
public class H6ParagraphElement extends TextParagraphElement {

    public H6ParagraphElement(Element element, XWPFDocument document) {
        super(element, document, new H6Style().withAttributes(element.attributes()));
    }
}

