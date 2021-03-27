package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringAttributeValue {
    protected final String regExp;
    protected final String defaultValue;
    protected final Attributes attributes;

    protected StringAttributeValue(String regExp, String defaultValue, Attributes attributes) {
        this.regExp = regExp;
        this.defaultValue = defaultValue;
        this.attributes = attributes;
    }

    public String value(){
        List<Attribute> attributeList = attributes.asList();
        for (Attribute attribute : attributeList){
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(attribute.getValue());
            if (matcher.find()) return matcher.group(1);
        }
        return defaultValue;
    }
}
