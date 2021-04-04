package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

public class FontWeight extends StringAttributeValue {

    public FontWeight(Attributes attributes) {
        super("font-weight:\\s?(.*);", "normal", attributes);
    }

    @Override
    public String toString() {
        return "font weight is " + this.value();
    }
}
