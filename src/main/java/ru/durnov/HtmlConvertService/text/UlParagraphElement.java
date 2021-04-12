package ru.durnov.HtmlConvertService.text;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.style.Style;

import java.io.IOException;
import java.util.List;

public class UlParagraphElement  extends  TextParagraphElement {

    public UlParagraphElement(Element element, XWPFDocument document, Style htmlStyle) {
        super(element, document, htmlStyle);
    }

    @Override
    public void addToXWPFDocument() throws IOException, InvalidFormatException {
        String marker = "* ";
        if (!element.ownText().equals("")){
            new SimplePParagraphElement(element, document, this.htmlStyle).addToXWPFDocument();
        }
        List<Node> nodeList = element.childNodes();
        for (Node node : nodeList){
            if (node.nodeName().equals("li")) {
                new LiParagraphElement(
                        marker,
                        (Element) node,
                        document,
                        htmlStyle
                ).addToXWPFDocument();
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
