package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;

/**
 * Общий элемент для заголовков тэг "h".
 * Будет абстактный метод setupFont, который мы переопределим
 * у наследников. Все остальное не переопределяем.
 */
public abstract class HElement extends TextElement{




    public HElement(Element element) {
        super(element);
    }

    public HElement(Element element, XWPFDocument document) {
        super(element, document);
    }
}
