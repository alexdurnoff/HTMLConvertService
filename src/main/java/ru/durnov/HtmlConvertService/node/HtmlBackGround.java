package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;

public class HtmlBackGround extends StringAttributeValue {
    public HtmlBackGround(Attribute attribute) {
        super("background-color: rgb([.*]);", "0,0,0", attribute);
    }
}
