package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.node.IntegerAttributeValue;

public class FontSize extends IntegerAttributeValue {
    public FontSize(Attributes attributes) {
        super("font-size:\\s([0-9]{1,2})px;", 16, attributes);
    }
}
