package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;

public class FontSize extends IntegerAttributeValue{
    protected FontSize(Attribute attribute) {
        super("font-size:\\s([0-9]{1,2})px;"
                , 16,
                attribute
        );
    }
}
