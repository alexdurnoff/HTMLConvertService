package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HtmlStyleTest {
    private HtmlStyle htmlStyle;
    private Attributes attributes;

    @BeforeEach
    public void setUp(){
        this.attributes = new TestAttributes().attributes();
        this.htmlStyle = new HtmlStyle(this.attributes);
    }

    @Test
    void withFont() {
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "font-size: 24px;");
        attributes1.add("style", "font-weight: bolder;");
        HtmlFont htmlFont = new HtmlFont(
                new FontSize(attributes1),
                new FontWeight(attributes1)
        );
        Style htmlStyle1 = this.htmlStyle.withFont(htmlFont);
        Assertions.assertTrue(htmlStyle1.toString().contains("fontSize is 24"));
        Assertions.assertTrue(htmlStyle1.toString().contains("font weight is bolder"));
    }

    @Test
    void withAlignment() {
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "text-alignment: left;");
        Style htmlStyle1 = this.htmlStyle.withAlignment(new HtmlAlignment(attributes1));
        Assertions.assertTrue(htmlStyle1.toString().contains("Alignment is left"));
    }

    @Test
    void withBackGround() {
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "background-color: rgb(0, 255, 0);");
        Style htmlStyle1 = this.htmlStyle.withBackGround(new HtmlBackGround(attributes1));
        Assertions.assertTrue(htmlStyle.toString().contains("BackGround is ffff00"));
        Assertions.assertTrue(htmlStyle1.toString().contains("BackGround is 00ff00"));
        Assertions.assertNotEquals(htmlStyle1.toString(), htmlStyle.toString());
    }

    @Test
    void testWithWidth(){
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "width:30px;");
        Style htmlStyle1 = this.htmlStyle.withWidth(new HtmlWidth(attributes1));
        Assertions.assertTrue(htmlStyle1.toString().contains("width is 30"));
    }

    @Test
    void withAttributesWithNewFontSize() {
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "font-size: 24px;");
        Style htmlStyle1 = this.htmlStyle.withAttributes(attributes1);
        Assertions.assertTrue(htmlStyle1.toString().contains("fontSize is 24"));
        Assertions.assertTrue(htmlStyle1.toString().contains("Alignment is center"));
        Assertions.assertTrue(htmlStyle1.toString().contains("BackGround is ffff00"));
        Assertions.assertTrue(htmlStyle1.toString().contains("font weight is normal"));
    }

    @Test
    public void withAttributesWithNewFontWeight(){
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "font-weight: bolder;");
        Style htmlStyle1 = this.htmlStyle.withAttributes(attributes1);
        Assertions.assertTrue(htmlStyle1.toString().contains("fontSize is 12"));
        Assertions.assertTrue(htmlStyle1.toString().contains("Alignment is center"));
        Assertions.assertTrue(htmlStyle1.toString().contains("BackGround is ffff00"));
        Assertions.assertTrue(htmlStyle1.toString().contains("font weight is bolder"));

    }

    @Test
    public void withAttributeWithNewAlignment(){
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "text-alignment: left;");
        Style htmlStyle1 = this.htmlStyle.withAttributes(attributes1);
        Assertions.assertTrue(htmlStyle1.toString().contains("fontSize is 16"));
        Assertions.assertTrue(htmlStyle1.toString().contains("Alignment is left"));
        Assertions.assertTrue(htmlStyle1.toString().contains("BackGround is ffff00"));
        Assertions.assertTrue(htmlStyle1.toString().contains("font weight is normal"));

    }

    @Test
    public void withAttributesWithNewBackGround(){
        Attributes attributes1 = new Attributes();
        attributes1.add("style", "background-color: rgb(0, 255, 0);");
        Style htmlStyle1 = this.htmlStyle.withAttributes(attributes1);
        Assertions.assertTrue(htmlStyle1.toString().contains("fontSize is 16"));
        Assertions.assertTrue(htmlStyle1.toString().contains("Alignment is center"));
        Assertions.assertTrue(htmlStyle1.toString().contains("BackGround is 00ff00"));
        Assertions.assertTrue(htmlStyle1.toString().contains("font weight is normal"));

    }
}