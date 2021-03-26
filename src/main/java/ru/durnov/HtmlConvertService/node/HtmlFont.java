package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlFont {
    private final Attribute attribute;

    public HtmlFont(Attribute attribute) {
        if (!(attribute.getValue().equals("font-size") || attribute.getValue().equals("font-weight"))){
            throw new IllegalArgumentException("Attribute must be font-size or font-weight");
        }
        this.attribute = attribute;
    }

    public int fontSize(){
        return new FontSize(attribute).value();
    }

    public String fontWeight(){
        return new FontWeight(attribute).value();
    }
}
