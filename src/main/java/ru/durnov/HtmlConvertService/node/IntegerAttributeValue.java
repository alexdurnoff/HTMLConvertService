package ru.durnov.HtmlConvertService.node;

import org.hibernate.id.factory.IdentifierGeneratorFactory;
import org.jsoup.nodes.Attribute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerAttributeValue {
    protected final String regExp;
    protected final int dafaultValue;
    protected final Attribute attribute;

    protected IntegerAttributeValue(String regExp, int defaultValue, Attribute attribute){
        this.regExp = regExp;
        this.dafaultValue = defaultValue;
        this.attribute = attribute;
    }

    public int value(){
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(attribute.getValue());
        try {
            if (matcher.find()) return Integer.parseInt(matcher.group(1));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return this.dafaultValue;
        }
        return this.dafaultValue;
    }
}
