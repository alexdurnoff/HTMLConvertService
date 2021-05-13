package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HtmlColorTest {

    @Test
    void value() {
        Attributes attributes = new Attributes();
        attributes.add("style", "color: #00f000");
        HtmlColor htmlColor = new HtmlColor(attributes);
        Assertions.assertEquals(htmlColor.value(), "00f000");
    }

    @Test
    public void testCompactColorAttributeString(){
        Attributes attributes = new Attributes();
        attributes.add("style", "color: #0f0");
        HtmlColor htmlColor = new HtmlColor(attributes);
        Assertions.assertEquals(htmlColor.value(), "00ff00");
    }

    @Test
    public void testCharacterColorAttributeString(){
        Attributes attributes = new Attributes();
        attributes.add("style", "color: red");
        HtmlColor htmlColor = new HtmlColor(attributes);
        Assertions.assertEquals(htmlColor.value(), "red");
    }
}