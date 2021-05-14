package ru.durnov.HtmlConvertService.style.border;

import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BorderAttributeTest {
    private BorderAttribute borderAttribute;


    @BeforeEach
    void setUp(){
        Attributes attributes = new Attributes();
        attributes.add("style", "border:1px dotted #f00000");
        borderAttribute = new BorderAttribute(attributes);
    }


    @Test
    void color() {
        String color = borderAttribute.color();
        Assertions.assertEquals(color, "f00000");

    }

    @Test
    void weight() {
        String weight = borderAttribute.weight();
        Assertions.assertEquals(weight, "1px");
    }

    @Test
    void borderStyle() {
        String borderStyle = borderAttribute.borderStyle();
        Assertions.assertEquals(borderStyle, "dotted");
    }

    @Test
    void testReturnNoneFromEmptyAttributes(){
        Attributes attributes = new Attributes();
        BorderAttribute attribute = new BorderAttribute(attributes);
        Assertions.assertEquals(attribute.color(), "auto");
        Assertions.assertEquals(attribute.weight(), "auto");
        Assertions.assertEquals(attribute.borderStyle(), "none");

    }

    @Test
    void testReturnNoneFromEmptyBorderStyle(){
        Attributes attributes = new Attributes();
        attributes.add("style", "border:");
        BorderAttribute attribute = new BorderAttribute(attributes);
        Assertions.assertEquals(attribute.color(), "auto");
        Assertions.assertEquals(attribute.weight(), "auto");
        Assertions.assertEquals(attribute.borderStyle(), "none");

    }
}