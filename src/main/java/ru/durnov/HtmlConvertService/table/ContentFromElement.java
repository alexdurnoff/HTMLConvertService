package ru.durnov.HtmlConvertService.table;

import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Element;

import java.util.List;

/**
 * Класс будет извлекать массив строк из текстового элемента.
 * Предположительно "p".
 */
public class ContentFromElement {
    private final Element element;
    private final String brRegExp = "<br>";
    private final String labelStartRegExp = "<label>";
    private final String labelEndRFegExp = "<label/>";
    private final String spanStartRegExp = "<span>";
    private final String spanEndRegExp = "<span/>";


    public ContentFromElement(Element element) {
        this.element = element;
    }

    public String[] content() {
        return null;
    }
}
