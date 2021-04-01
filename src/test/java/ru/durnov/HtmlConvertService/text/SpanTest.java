package ru.durnov.HtmlConvertService.text;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SpanTest {
    private Document document;
    private Element body;

    @BeforeEach
    public void setUp() throws IOException {
        this.document = Jsoup.parse(Files.readString(Path.of("Test/4.html")));
        this.body = document.body();
    }

    @Test
    public void testSpanStructure(){
        List<Element> spanElements = body.getElementsByTag("span");
        spanElements.forEach(element -> {
            System.out.println(element.childNodeSize());
            Elements spans = element.getElementsByTag("span");
            spans.forEach(element1 -> {
                System.out.println(element1.ownText());
            });
        });

    }

    @Test
    public void testPTextStructure(){
        List<Element> pElements = body.getElementsByTag("p");
        StringBuilder stringBuilder = new StringBuilder();
        pElements.forEach(element -> {
            stringBuilder.append(element.ownText());
            Elements spans = element.getElementsByTag("span");
            spans.forEach(element1 -> {
                stringBuilder.append(element1.ownText());
            });
            stringBuilder.append('\n');
        });
        System.out.println(stringBuilder.toString());
    }
}
