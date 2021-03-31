package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

/**
 * Класс атрибутов тэга strong
 */
public class StrongAttaributes {

    public Attributes attributes(){
        Attributes attributes = new Attributes();
        attributes.add("style", "font-weight: bolder;");
        return attributes;
    }
}
