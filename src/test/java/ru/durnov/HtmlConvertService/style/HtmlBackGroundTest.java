package ru.durnov.HtmlConvertService.style;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class HtmlBackGroundTest {

    @Test
    void value() throws IOException {
        String content = Files.readString(Path.of("Test/4.html"));
        Document document = Jsoup.parse(content);
        document.body().getAllElements().forEach(element -> {
            Attributes attributes = element.attributes();
            List<Attribute> attributeList = attributes.asList();
            for (Attribute attribute : attributeList) {
                System.out.println(attribute.getKey());
                if (attribute.getKey().equals("style")){
                    System.out.println(attribute.getValue());
                    HtmlBackGround htmlBackGround = new HtmlBackGround(attributes);
                    System.out.println(htmlBackGround.value());
                }
            }
        });
    }

    @Test
    public void dummyTest(){
        String expression = "background-color: rgb(255, 255, 0);";
        String regExp = "^background-color:\\srgb\\(([0-9]{1,3}),\\s?([0-9]{1,3}),\\s?([0-9]{1,3})\\);$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(expression);
        System.out.println(matcher.matches());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
    }

    @Test
    public void testDefaultValue(){
        String expression = "background-color: rgb(0, 0, 0);";
        String regExp = "^background-color:\\srgb\\(([0-9]{1,3}),\\s?([0-9]{1,3}),\\s?([0-9]{1,3})\\);$";
    }

    @Test
    public void testBackGroungWithRGBValue(){
        Attributes attributes = new Attributes();
        attributes.add("style", "background-color: rgb(255, 255, 0);");
        HtmlBackGround htmlBackGround = new HtmlBackGround(attributes);
        Assertions.assertTrue(htmlBackGround.toString().contains("ffff00"));
    }

    @Test
    public void testBackGroungWithColorStringvalue(){
        Attributes attributes = new Attributes();
        attributes.add("style", "background-color: green");
        HtmlBackGround htmlBackGround = new HtmlBackGround(attributes);
        Assertions.assertTrue(htmlBackGround.toString().contains("green"));
    }
}