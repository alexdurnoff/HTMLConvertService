package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HtmlAlignmentTest {


    @Test
    void paragraphAlignment() {
        String html = "<p style=\"text-align: center;\"><span style=\"font-weight: bolder;\"><span style=\"font-size: 24px;\">П Р И К А\n" +
                "      З</span></span></p>";
        Document document = Jsoup.parse(html);
        Element element = document.body().getAllElements().get(1);//Нулевой элемент - это сам боди.
        Attributes attributes = element.attributes();
        HtmlAlignment htmlAlignment = new HtmlAlignment(attributes);
        Assertions.assertEquals(htmlAlignment.paragraphAlignment(), ParagraphAlignment.CENTER);
    }
}