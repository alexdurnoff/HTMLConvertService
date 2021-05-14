package ru.durnov.HtmlConvertService.style.border;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HtmlBorderStyleTest {

    @Test
    void testSimpleSolidW(){
        Attributes attributes = new Attributes();
        attributes.add("style", "border:1px solid #f00000");
        HtmlBorderStyle htmlBorderStyle = new HtmlBorderStyle(new BorderAttribute(attributes));
        Assertions.assertEquals(htmlBorderStyle.borderStyle().name(), "THIN");
    }

    @Test
    void testMediumSolidWith(){
        Attributes attributes = new Attributes();
        attributes.add("style", "border:3px solid #f00000");
        HtmlBorderStyle htmlBorderStyle = new HtmlBorderStyle(new BorderAttribute(attributes));
        Assertions.assertEquals(htmlBorderStyle.borderStyle().name(), "MEDIUM");
    }

    @Test
    void testTHICKSolidWith(){
        Attributes attributes = new Attributes();
        attributes.add("style", "border:5px solid #f00000");
        HtmlBorderStyle htmlBorderStyle = new HtmlBorderStyle(new BorderAttribute(attributes));
        Assertions.assertEquals(htmlBorderStyle.borderStyle().name(), "THICK");
    }

}