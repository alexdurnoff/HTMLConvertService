package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.H2Style;
import ru.durnov.HtmlConvertService.style.H5Style;

/**
 * Элемент заголовка h5.
 * По умолчанию у него будет 12-й шрифт.
 * Пока что отличается от TextElement только шрифтом.
 */
public class H5ParagraphElement extends TextParagraphElement {

    public H5ParagraphElement(Element element, XWPFDocument document) {
        super(element, document, new H5Style().withAttributes(element.attributes()));
    }
}

