package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.H1Style;
import ru.durnov.HtmlConvertService.style.H2Style;

/**
 * Элемент заголовка h1.
 * По умолчанию у него будет 28-й шрифт.
 * Пока что отличается от TextElement только шрифтом.
 */
public class H1ParagraphElement extends TextParagraphElement {

    public H1ParagraphElement(Element element, XWPFDocument document) {
        super(element, document, new H1Style().withAttributes(element.attributes()));
    }
}

