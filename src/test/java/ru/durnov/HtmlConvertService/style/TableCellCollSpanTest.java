package ru.durnov.HtmlConvertService.style;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicReference;

class TableCellCollSpanTest {
    private Element htmlCell;

    @BeforeEach
    public void setUp() throws IOException {
        String html = Files.readString(Path.of("Test/1.html"));
        Document document = Jsoup.parse(html);
        Elements allElements = document.body().getAllElements();
        for (Element element : allElements){
            System.out.println(element.nodeName());
            if (element.nodeName().equals("td")){
                htmlCell = element;
                System.out.println(new TableCellCollSpan(htmlCell).collspan());
            }
        }

    }

    @Test
    void collspan() {

    }
}