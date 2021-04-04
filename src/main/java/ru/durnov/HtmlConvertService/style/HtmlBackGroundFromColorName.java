package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlBackGroundFromColorName extends StringAttributeValue{
    protected HtmlBackGroundFromColorName(Attributes attributes) {
        super("^background-color:\\s?([a-zA-Z]{1,});?$", "auto", attributes);
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
                        return matcher.group(1);
                    }
                }
            }
        }
        return "auto";
    }
}
