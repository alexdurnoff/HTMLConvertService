package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Node;

public class PNode implements HtmlNode{
    private final Node pNode;

    public PNode(Node pNode) {
        if (! pNode.nodeName().equals("p")) throw new IllegalArgumentException("Node must be p-node");
        this.pNode = pNode;
    }


    @Override
    public void addToXWPFDocument() {


    }
}
