package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.Style;

public class LiParagraphElement implements DocxParagraphElement {
    private final int number;
    private final Element element;
    private final XWPFDocument xwpfDocument;
    private final Style htmlStyle;

    public LiParagraphElement(int number, Element element, XWPFDocument xwpfDocument, Style htmlStyle) {
        this.number = number;
        this.element = element;
        this.xwpfDocument = xwpfDocument;
        this.htmlStyle = htmlStyle;
    }

    @Override
    public void addToXWPFDocument() {

    }

}
