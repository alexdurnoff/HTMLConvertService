package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.Style;

/**
 * Чтобы не плодить копи-пасту отнаследовались от TextElement.
 * Вместо текста вставляем перевод строки.
 */
public class BRParagraphElement extends TextParagraphElement {


    public BRParagraphElement(Element pNodeElement) {
        super(pNodeElement);
    }

    public BRParagraphElement(Element pNodeElement, XWPFDocument document) {
        super(pNodeElement, document);
    }

    public BRParagraphElement(Element pNodeElement, XWPFDocument document, Style htmlStyle) {
        super(pNodeElement, document, htmlStyle);
    }

    @Override
    public void addToXWPFDocument() {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        htmlStyle.applyToRun(run);
        run.addBreak();
    }
}
