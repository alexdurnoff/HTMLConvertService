package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.style.Style;

import java.util.List;

public class OlParagraphElement extends TextParagraphElement {

    public OlParagraphElement(Element element) {
        super(element);
    }

    public OlParagraphElement(Element element, XWPFDocument document) {
        super(element, document);
    }

    public OlParagraphElement(Element element, XWPFDocument document, Style htmlStyle) {
        super(element, document, htmlStyle);
    }

    @Override
    public void addToXWPFDocument() {
        int number = 1;
        if (!element.ownText().equals("")){
            new SimplePParagraphElement(element, document, this.htmlStyle).addToXWPFDocument();
        }
        List<Node> nodeList = element.childNodes();
        for (Node node : nodeList){
            if (node.nodeName().equals("li")) {
                new LiParagraphElement(
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
