package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

public class HtmlWidth extends IntegerAttributeValue{

    public HtmlWidth(Attributes attributes) {
        super("width:\\s?([0-9]{1,2})px", 15, attributes);
    }

    @Override
    public String toString() {
        return "width is " + this.value();
    }
}
