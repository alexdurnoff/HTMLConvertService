package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс соответствует цвету в атрибутах html-файла.
 */
public class HtmlColor extends StringAttributeValue{


    public HtmlColor(Attributes attributes) {
        super("^color:\\s?(.{1,})$", "auto", attributes);
    }

    @Override
    public String value() {
        Pattern pattern = Pattern.compile(this.regExp);
        List<Attribute> attributeList = this.attributes.asList();
        for (Attribute attribute : attributeList) {
            if (attribute.getKey().equals("style")){
                String value = attribute.getValue();
                if (value != null){
                    Matcher matcher = pattern.matcher(value);
                    if (matcher.matches()){
                        String color = matcher.group(1);
                        if (color.startsWith("#")){
                            if (color.length() <=4){
                                return new FullHexColorValue(
                                        new ColorValueWithOutSharp(color).hexValue()
                                ).fullValue();
                            } else {
                                return new ColorValueWithOutSharp(color).hexValue();
                            }
                        } else {
                            return color;
                        }
                    }
                }
            }
        }
        return "auto";
    }
}
