package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlBackGroundFromHexRGB extends StringAttributeValue{
    public HtmlBackGroundFromHexRGB(Attributes attributes) {
        super("^background-color:\\s?#[0-9a-fA-F]{3,6};?$",
                "auto",
                attributes);
    }

    @Override
    public String value() {
        Pattern pattern = Pattern.compile(this.regExp);
        List<Attribute> attributeList = this.attributes.asList();
        for (Attribute attribute : attributeList) {
            if (attribute.getKey().equals("style")){
                Matcher matcher = pattern.matcher(attribute.getValue());
                if (matcher.matches()) {
                    String value = attribute.getValue();
                    value = new ColorValueWithOutSharp(value).hexValue();
                    if (value.length() <= 4){
                        value = new FullHexColorValue(value).fullValue();
                    }
                    return value.replace(";", "");
                }
            }
        }
        return "auto";
    }


}
