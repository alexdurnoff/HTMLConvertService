package ru.durnov.HtmlConvertService.text;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.Style;

import java.io.IOException;

/**
 * Элемент гиперссылка.
 */
public class HyperLinkParagraphElement implements DocxParagraphElement {
    private final Element element;
    private final XWPFDocument xwpfDocument;
    private final Style htmlStyle;


    public HyperLinkParagraphElement(Element element, XWPFDocument document, Style htmlStyle) {
        this.element = element;
        this.xwpfDocument = document;
        this.htmlStyle = htmlStyle;
    }

    @Override
    public void addToXWPFDocument() throws IOException, InvalidFormatException {
        XWPFParagraph paragraph = xwpfDocument.createParagraph();
        XWPFHyperlinkRun xwpfHyperlinkRun = paragraph.createHyperlinkRun(
                element.attributes().get("href")
        );
        xwpfHyperlinkRun.setText(new TextFromHyperLinkElement(element).text());
        htmlStyle.applyToRun(xwpfHyperlinkRun);
        xwpfHyperlinkRun.setUnderline(UnderlinePatterns.SINGLE);
        xwpfHyperlinkRun.setColor("0000FF");
    }
}
