package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

/**
 * Класс создает атрибуты для тэга h6
 */
public class H6Attributes {
    private final Attributes attributes;

    public H6Attributes(){
        this.attributes = new Attributes();
        attributes.add("style", "font-size: 8px;");
    }

    public Attributes attributes(){
        return this.attributes;
    }

    @Override
    public String toString() {
        return "H6Attributes = " + attributes.toString();
    }
}
