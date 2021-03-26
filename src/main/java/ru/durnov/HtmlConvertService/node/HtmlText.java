package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Node;

import java.util.Optional;

public class HtmlText {
    private final Node spanNode;

    public HtmlText(Node spanNode) {
        this.spanNode = spanNode;
    }

    public Optional<String> text(){
        String text = spanNode.attributes().get("text");
        return Optional.of(text);
    }
}
