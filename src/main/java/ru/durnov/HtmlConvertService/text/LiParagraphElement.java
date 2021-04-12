package ru.durnov.HtmlConvertService.text;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.Style;

@Slf4j
public class LiParagraphElement implements DocxParagraphElement {
    private final String number;
    private final Element element;
    private final XWPFDocument xwpfDocument;
    private final Style htmlStyle;

    public LiParagraphElement(String number, Element element, XWPFDocument xwpfDocument, Style htmlStyle) {
        log.debug("number is " + number);
        this.number = number;
        this.element = element;
        this.xwpfDocument = xwpfDocument;
        this.htmlStyle = htmlStyle;
    }

    @Override
    public void addToXWPFDocument() {
        XWPFParagraph paragraph = xwpfDocument.createParagraph();
        XWPFRun run = paragraph.createRun();
        htmlStyle.applyToRun(run);
        run.setText(number + element.ownText());
    }

}
