package ru.durnov.HtmlConvertService.style;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.jsoup.nodes.Attributes;

/**
 * Класс создает атрибуты по умолчанию для тэга h2
 */
public class H2Attributes {
    private final Attributes attributes;

    public H2Attributes() {
        this.attributes = new Attributes();
        attributes.add("style", "font-size: 24px;");
    }

    public Attributes attributes(){
        return this.attributes;
    }

    @Override
    public String toString() {
        return "H2Attributes = " + attributes.toString();
    }

}
