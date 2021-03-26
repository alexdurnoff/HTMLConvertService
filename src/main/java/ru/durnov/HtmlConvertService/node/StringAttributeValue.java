package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringAttributeValue {
    protected final String regExp;
    protected final String defaultValue;
    protected final Attribute attribute;

    protected StringAttributeValue(String regExp, String defaultValue, Attribute attribute) {
        this.regExp = regExp;
        this.defaultValue = defaultValue;
        this.attribute = attribute;
    }

    public String value(){
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(attribute.getValue());
        if (matcher.find()) return matcher.group(1);
        return defaultValue;
    }
}
