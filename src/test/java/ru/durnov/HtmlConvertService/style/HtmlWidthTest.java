package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class HtmlWidthTest {

    @Test
    public void testWidth(){
        Attributes attributes = new Attributes();
        attributes.add("style", "width:30px");
        HtmlWidth htmlWidth = new HtmlWidth(attributes);
        Assertions.assertTrue(htmlWidth.toString().contains("30"));
        Assertions.assertEquals(htmlWidth.value(), 30);
    }

}