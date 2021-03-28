package ru.durnov.HtmlConvertService.style;

import org.hibernate.id.factory.IdentifierGeneratorFactory;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerAttributeValue {
    protected final String regExp;
    protected final int dafaultValue;
    protected final Attributes attributes;

    protected IntegerAttributeValue(String regExp, int defaultValue, Attributes attributes){
        this.regExp = regExp;
        this.dafaultValue = defaultValue;
        this.attributes = attributes;
    }

    public int value(){
        List<Attribute> attributes = this.attributes.asList();
        for (Attribute attribute : attributes) {
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(attribute.getValue());
            try {
                if (matcher.find()) return Integer.parseInt(matcher.group(1));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return this.dafaultValue;
            }
        }
        return this.dafaultValue;
    }
}
