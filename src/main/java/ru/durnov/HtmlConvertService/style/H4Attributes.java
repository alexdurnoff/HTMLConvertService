package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

/**
 * Класс создает атрибуты для тэга h4
 */
public class H4Attributes {
    private final Attributes attributes;

    public H4Attributes(){
        this.attributes = new Attributes();
        attributes.add("style", "font-size: 16px;");
    }

    public Attributes attributes(){
        return this.attributes;
    }

    @Override
    public String toString() {
        return "H4Attributes = " + attributes.toString();
    }
}
