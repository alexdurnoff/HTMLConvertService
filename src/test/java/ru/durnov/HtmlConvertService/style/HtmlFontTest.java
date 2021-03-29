package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HtmlFontTest {
    HtmlFont htmlFont;

    @BeforeEach
    public void setUp(){
        Attributes attributes = new TestAttributes().attributes();
        this.htmlFont = new HtmlFont(
                new FontSize(attributes),
                new FontWeight(attributes)
        );
    }

    @Test
    void withFontSize() {
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "font-size: 24px;");
        FontSize fontSize = new FontSize(attributes1);
        System.out.println(fontSize);
        HtmlFont htmlFont = this.htmlFont.withFontSize(
                fontSize
        );
        System.out.println(htmlFont);
        Assertions.assertTrue(htmlFont.toString().contains("fontSize is 24"));
        Assertions.assertTrue(htmlFont.toString().contains("font weight is normal"));
    }

    @Test
    void withFontWeight() {
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "font-weight: bolder;");
        FontWeight fontWeight = new FontWeight(attributes1);
        System.out.println(fontWeight);
        HtmlFont htmlFont = this.htmlFont.withFontWeight(
                fontWeight
        );
        System.out.println(htmlFont);
        Assertions.assertTrue(htmlFont.toString().contains("fontSize is 16"));
        Assertions.assertTrue(htmlFont.toString().contains("font weight is bolder"));
    }
}