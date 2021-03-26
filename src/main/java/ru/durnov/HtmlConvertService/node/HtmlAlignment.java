package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlAlignment extends StringAttributeValue {
    protected HtmlAlignment(Attribute attribute) {
        super("text-align:\\s(.*);", "center", attribute);
    }
}
