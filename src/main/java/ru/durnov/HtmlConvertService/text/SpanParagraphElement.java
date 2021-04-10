package ru.durnov.HtmlConvertService.text;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;

import java.io.IOException;

/**
 * По сути класс оказался таким же, как и класс для тэга p.
 * Поэтому его пока не используем.
 */
@Deprecated
public class SpanParagraphElement implements DocxParagraphElement {
    private final Element element;
    private final XWPFDocument document;
    private final Style htmlStyle;


    public SpanParagraphElement(Element element, XWPFDocument document) {
        this.element = element;
        this.document = document;
        this.htmlStyle = new HtmlStyle(element.attributes());
    }

    public SpanParagraphElement(Element element, XWPFDocument document, HtmlStyle htmlStyle) {
        System.out.println(htmlStyle);
        this.element = element;
        this.document = document;
        this.htmlStyle = htmlStyle.withAttributes(element.attributes());
    }

    @Override
    public void addToXWPFDocument() {
        if (!element.ownText().equals("")){
            new SimplePParagraphElement(element, document, htmlStyle).addToXWPFDocument();
        }
        element.childNodes().forEach(node -> {
            if (node.getClass() == Element.class){
                try {
                    new ElementFactory(
                            node,
                            document,
                            htmlStyle
                    )
                            .elementByName()
                            .addToXWPFDocument();
                } catch (IOException | InvalidFormatException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
