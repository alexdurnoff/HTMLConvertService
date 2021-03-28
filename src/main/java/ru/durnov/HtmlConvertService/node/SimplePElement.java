package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

/**
 * Класс инкапсулирует в себе элемент со своим собственным текстом.
 */
public class SimplePElement implements HtmlElement {
    private final Element pNodeElement;
    private final XWPFDocument document;
    private final HtmlStyle htmlStyle;


    public SimplePElement(Element pNodeElement, XWPFDocument document) {
        this.pNodeElement = pNodeElement;
        this.document = document;
        this.htmlStyle = new HtmlStyle(this.pNodeElement.attributes());
    }

    public SimplePElement(Element pNodeElement, XWPFDocument document, HtmlStyle htmlStyle) {
        this.pNodeElement = pNodeElement;
        this.document = document;
        this.htmlStyle = htmlStyle.withAttributes(this.pNodeElement.attributes());
    }

    @Override
    public void addToXWPFDocument() {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        htmlStyle.applyToRun(run);
        run.setText(pNodeElement.ownText());
    }
}
