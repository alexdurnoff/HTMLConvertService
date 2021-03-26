package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;

public class FontWeight extends StringAttributeValue{
    protected FontWeight(Attribute attribute) {
        super("font-weight:\\s(.*);", "normal", attribute);
    }
}
