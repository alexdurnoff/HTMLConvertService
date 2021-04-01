package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;

/**
 * Общий элемент для заголовков тэг "h".
 * Будет абстактный метод setupFont, который мы переопределим
 * у наследников. Все остальное не переопределяем.
 */
public abstract class HParagraphElement extends TextParagraphElement {




    public HParagraphElement(Element element) {
        super(element);
    }

    public HParagraphElement(Element element, XWPFDocument document) {
        super(element, document);
    }
}
