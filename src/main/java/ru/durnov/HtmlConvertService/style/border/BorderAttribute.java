package ru.durnov.HtmlConvertService.style.border;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.ColorValueWithOutSharp;
import ru.durnov.HtmlConvertService.style.FullHexColorValue;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс будет возвращать параметры border для html-таблицы.
 */
public class BorderAttribute {
    private final Attribute attribute;
    private static final Pattern weightPattern = Pattern.compile("[0-9]px");
    private static final Pattern RGBColorPattern = Pattern.compile("#[A-Fa-f0-9]{3,6}");
    private static final Pattern stylePattern = Pattern.compile("(solid)|(dotted)|(dashed)|(double)|(groove)|(ridge)|(inset)|(outset)");

    public  BorderAttribute(Attributes attributes){
        if (attributes.hasKey("style")){
            this.attribute = new Attribute("style", attributes.get("style"));
        } else {
            this.attribute = new Attribute("style", "");
        }
    }

    public String color(){
        Matcher matcher = RGBColorPattern.matcher(attribute.getValue());
        String color = "auto";
        if (matcher.find()){
            color = matcher.group();
            if (color.length() <=4){
                return new FullHexColorValue(
                        new ColorValueWithOutSharp(color).hexValue()
                ).fullValue();
            } else {
                return new ColorValueWithOutSharp(color).hexValue();
            }
        }
        return color;
    }

    public String weight(){
        Matcher matcher = weightPattern.matcher(attribute.getValue());
        if (matcher.find()){
            return matcher.group();
        }
        return "auto";
    }

    public String borderStyle(){
        Matcher matcher = stylePattern.matcher(attribute.getValue());
        if (matcher.find()){
            return matcher.group();
        }
        return "none";
    }


}
