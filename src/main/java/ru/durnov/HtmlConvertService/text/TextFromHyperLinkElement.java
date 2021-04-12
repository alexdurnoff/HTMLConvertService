package ru.durnov.HtmlConvertService.text;

import org.jsoup.nodes.Element;

/**
 * Класс достает текст из тэга <a></a>
 */
public class TextFromHyperLinkElement {
    private final Element element;

    public TextFromHyperLinkElement(Element element) {
        this.element = element;
    }

    /**
     * Возвращает либо текст элемента, либо его ссылку, если текста нет.
     * @return
     */
    public String text(){
        if (element.text().equals("")) return element.attributes().get("href");
        return element.text();
    }
}
