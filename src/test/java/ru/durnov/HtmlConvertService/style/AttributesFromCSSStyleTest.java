package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.css.AttributesFromCSSStyle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AttributesFromCSSStyleTest {

    private String styleString;


    @BeforeEach
    public void setUp(){
        styleString = "<style>\n" +
                "  .table td {\n" +
                "    border: 1px solid grey;\n" +
                "  }\n" +
                "</style>";
    }

    @Test
    void attributes() {
        Attributes attributes = new AttributesFromCSSStyle(styleString).attributes();
        System.out.println(attributes);
    }

    @Test
    public void setupRegExp(){
        String regExp = "([a-z]{1,}:)\\s?(.+)[\\s;]";
        String nameRegExp = "([a-z]{1,}:)";
        String  valueRegExp = "\\s?([0-9a-zA-Z]+)[\\s;]";
        Pattern pattern = Pattern.compile(nameRegExp);
        Matcher nameMatcher = pattern.matcher(styleString);
        System.out.println(nameMatcher.find());
        System.out.println(nameMatcher.group());
        pattern = Pattern.compile(valueRegExp);
        Matcher valueMatcher = pattern.matcher(styleString);
        while (valueMatcher.find()){
            System.out.println(valueMatcher.group());
        }
    }

    @Test
    public void testStringPart(){
        String regExp = "\\{[0-9a-zA-z;\\s:}]{1,}";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(styleString);
        while (matcher.find()) System.out.println(matcher.group());
        System.out.println(styleString.matches(regExp));
    }

    @Test
    public void testConcateNameAndValueRegexp(){
        String  valueRegExp = "\\s?([0-9a-zA-Z]+)[\\s;]";
        String name = "border:";
        String regExp = name +
           valueRegExp;
        System.out.println(regExp);
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(styleString);
        System.out.println(matcher.find());
    }

    @Test
    public void testConcatinateRegexpWithOneSlash(){
        String regExp = "border:\\s?([0-9a-zA-Z]+)[\\s;]";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(styleString);
        System.out.println(matcher.find());
        System.out.println(matcher.group());
    }

    @Test
    public void testParseKeyPlusValuesExpression(){
        String source ="{\n" +
                "    border: 1px solid grey;\n" +
                "  }";
        String keyPlusValueRegExp = "border:" + ".+;";
        Pattern pattern = Pattern.compile(keyPlusValueRegExp);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) System.out.println(matcher.group());
    }
}