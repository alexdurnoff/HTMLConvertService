package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlBackGround extends StringAttributeValue {

    public HtmlBackGround(Attributes attributes) {
        super("^background-color:\\s?(.{1,})$", "auto", attributes);
    }



    @Override
    public String value() {
        String value = super.value();
        if (value.contains("rgb")){
            return new HtmlBackGroundFromRgb(attributes).value();
        }
        return new HtmlBackGroundFromColorName(attributes).value();
    }

    @Override
    public String toString() {
        return "BackGround is " + this.value();
    }
}
