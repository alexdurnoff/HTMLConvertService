package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

import java.util.List;

public class CSSKeyValuePairs {
    private final List<String> styleStringList;

    public CSSKeyValuePairs(final List<String> styleStringList) {
        this.styleStringList = styleStringList;
    }

    public void putToAttributes(final Attributes attributes) {
        for (String source : styleStringList) {
            new CSSKeyValuePair(source).putToAttributes(attributes);
        }
    }
}
