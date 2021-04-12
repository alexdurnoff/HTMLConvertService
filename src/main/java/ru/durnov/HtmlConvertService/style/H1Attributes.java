package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

/**
 * Класс создает атрибуты для тэга h1
 */
public class H1Attributes {
    private final Attributes attributes;

    public H1Attributes(){
        this.attributes = new Attributes();
        attributes.add("style", "font-size: 28px;");
    }

    public Attributes attributes(){
        return this.attributes;
    }

    @Override
    public String toString() {
        return "H1Attributes = " + attributes.toString();
    }
}
