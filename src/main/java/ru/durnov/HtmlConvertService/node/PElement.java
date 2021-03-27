package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;


public class PElement implements HtmlElement {
    private final Element pNodeElement;
    private final XWPFDocument document;

    public PElement(Element pNodeElement) {
        if (! pNodeElement.nodeName().equals("p")) throw new IllegalArgumentException("Node must be p-node");
        this.pNodeElement = pNodeElement;
        this.document = new XWPFDocument();
    }

    public PElement(Element pNodeElement, XWPFDocument document) {
        if (! pNodeElement.nodeName().equals("p")) throw new IllegalArgumentException("Node must be p-node");
        this.pNodeElement = pNodeElement;
        this.document = document;
    }

    @Override
    public void addToXWPFDocument() {
        if (!pNodeElement.ownText().equals("")){
            new SimplePElement(pNodeElement, document).addToXWPFDocument();
        }
        pNodeElement.childNodes().forEach(node -> {
            if (node.getClass() == Element.class){
                new ElementFactory(node, document)
                        .elementByName()
                        .addToXWPFDocument();
            }
        });
    }
}
