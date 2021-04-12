package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

/**
 * Класс создает атрибуты для тэга h3
 */
public class H3Attributes {
    private final Attributes attributes;

    public H3Attributes(){
        this.attributes = new Attributes();
        attributes.add("style", "font-size: 20px;");
    }

    public Attributes attributes(){
        return this.attributes;
    }

    @Override
    public String toString() {
        return "H3Attributes = " + attributes.toString();
    }
}
