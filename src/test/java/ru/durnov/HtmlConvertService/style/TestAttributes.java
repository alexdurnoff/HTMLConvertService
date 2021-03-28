package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

/**
 * Класс инкапсулирует тестовую версию атрибуотов.
 */
public class TestAttributes {
    private final Attributes attributes;

    public TestAttributes(){
        this.attributes = new Attributes();
        attributes.add("style", "font-size: 16px;");
        attributes.add("style", "font-weight: normal;");
        attributes.add("style", "text-align: center;");
        attributes.add("style", "background-color: rgb(255, 255, 0);");
    }

    public Attributes attributes(){return this.attributes;}
}
