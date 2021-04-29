package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class HtmlBackGroundFromHexRGBTest {

    @Test
    public void testValue() {
        Attributes attributes = new Attributes();
        attributes.add("style", "background-color: #ff0;");
        String value = new HtmlBackGroundFromHexRGB(attributes).value();
        Assertions.assertEquals(value, "ffff00");
    }

    @Test
    public void testRegExp(){
        String string = "background-color: #ff0;";
        String regExp = "^background-color:\\s?#[0-9a-fA-F]{3,6};?$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(string);
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    public void testFullStringValue(){
        Attributes attributes = new Attributes();
        attributes.add("style", "background-color: #00ff00;");
        String value = new HtmlBackGroundFromHexRGB(attributes).value();
        Assertions.assertEquals(value, "00ff00");

    }
}