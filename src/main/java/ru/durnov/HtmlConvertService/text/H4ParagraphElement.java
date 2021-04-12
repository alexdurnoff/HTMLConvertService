package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.H2Style;
import ru.durnov.HtmlConvertService.style.H4Style;

/**
 * Элемент заголовка h4.
 * По умолчанию у него будет 16-й шрифт.
 * Пока что отличается от TextElement только шрифтом.
 */
public class H4ParagraphElement extends TextParagraphElement {

    public H4ParagraphElement(Element element, XWPFDocument document) {
        super(element, document, new H4Style().withAttributes(element.attributes()));
    }
}

