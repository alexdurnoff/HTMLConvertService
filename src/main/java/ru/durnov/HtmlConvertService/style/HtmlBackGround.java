package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlBackGround extends StringAttributeValue {

    public HtmlBackGround(Attributes attributes) {
        super("^background-color:\\srgb\\(([0-9]{1,3}),\\s?([0-9]{1,3}),\\s?([0-9]{1,3})\\);$", "auto", attributes);
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
                        return new StringForColor(matcher.group(1)).colorString()
                                + new StringForColor(matcher.group(2)).colorString()
                                + new StringForColor(matcher.group(3)).colorString();
                    }
                }
            }
        }
        return "auto";
    }

    @Override
    public String toString() {
        return "BackGround is " + this.value();
    }
}
