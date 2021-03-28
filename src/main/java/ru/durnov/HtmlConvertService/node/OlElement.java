package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

import java.util.List;

public class OlElement extends TextElement {

    public OlElement(Element element) {
        super(element);
    }

    public OlElement(Element element, XWPFDocument document) {
        super(element, document);
    }

    public OlElement(Element element, XWPFDocument document, HtmlStyle htmlStyle) {
        super(element, document, htmlStyle);
    }

    @Override
    public void addToXWPFDocument() {
        int number = 1;
        if (!element.ownText().equals("")){
            new SimplePElement(element, document, this.htmlStyle).addToXWPFDocument();
        }
        List<Node> nodeList = element.childNodes();
        for (Node node : nodeList){
            if (node.nodeName().equals("li")) {
                new LiElement(
                        number,
                        (Element) node,
                        document,
                        htmlStyle
                ).addToXWPFDocument();
                number++;
            } else {
                if (node.getClass() == Element.class){
                    Element element = (Element) node;
                    new ElementFactory(
                            element,
                            document,
                            htmlStyle
                    ).elementByName().addToXWPFDocument();
                }
            }
        }
    }


}
