package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.List;
import java.util.Optional;

public class HtmlText {
    private final Element element;

    public HtmlText(Element element) {
        this.element = element;
    }

    public String text(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(element.text());
        return stringBuilder.toString();
    }

}
