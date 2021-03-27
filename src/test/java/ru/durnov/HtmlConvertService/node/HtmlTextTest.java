package ru.durnov.HtmlConvertService.node;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HtmlTextTest {

    @Test
    void text() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Document document = Jsoup.parse(Files.readString(Path.of("Test/4.html")));
        Element body = document.body();
        Elements children = body.children();
        for (Element element : children){
            System.out.println(element.nodeName());
            element.attributes().asList().forEach(attribute -> {
                System.out.println(attribute.getKey() + " = " + attribute.getValue());
            });
            System.out.println();
            stringBuilder.append(element.text());
        }
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void test2Text() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Document document = Jsoup.parse(Files.readString(Path.of("Test/4.html")));
        Element body = document.body();
        System.out.println(body.childNodes().size());
        body.childNodes().forEach(node -> {
            addTextToStringBuilder(node, stringBuilder);
        });
        System.out.println(stringBuilder.toString());
    }

    private void addTextToStringBuilder(Node node, StringBuilder stringBuilder){
        if (node.getClass() == Element.class){
            Element element = (Element) node;
            stringBuilder.append(element.text());
            if (node.nodeName().equals("p")) stringBuilder.append('\n');
        }
        node.childNodes().forEach(node1 -> {
            if (node1.nodeName().equals("br")) stringBuilder.append('\n');
        });
    }

    @Test
    public void testSpanTags() throws IOException {
        Document document = Jsoup.parse(Files.readString(Path.of("Test/4.html")));
        Element body = document.body();
        StringBuilder stringBuilder = new StringBuilder();
        List<Node> nodeList = body.childNodes();
        for (Node node : nodeList){
            if (node.nodeName().equals("p")){
                Element element = (Element) node;
            }
        }
        System.out.println(stringBuilder);
    }



    private void addSpanTextToStringBuilder(Element element, StringBuilder stringBuilder){
        System.out.println(element);
        List<Element> spans = new ArrayList<>();
        element.childNodes().forEach(node -> {
            if (node.nodeName().equals("span")){
                spans.add((Element) node);
            }
        });
        System.out.println(spans.size());
        if (spans.size() >0){
            spans.forEach(element1 -> {
                System.out.println(element1);
                addSpanTextToStringBuilder(element1, stringBuilder);
            });
        } else {
            stringBuilder.append(element.text());
            System.out.println(stringBuilder);
        }
    }
}