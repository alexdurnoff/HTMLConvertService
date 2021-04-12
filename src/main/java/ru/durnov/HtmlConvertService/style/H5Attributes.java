package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

/**
 * Класс создает атрибуты для тэга h5
 */
public class H5Attributes {
    private final Attributes attributes;

    public H5Attributes(){
        this.attributes = new Attributes();
        attributes.add("style", "font-size: 12px;");
    }

    public Attributes attributes(){
        return this.attributes;
    }

    @Override
    public String toString() {
        return "H5Attributes = " + attributes.toString();
    }
}
