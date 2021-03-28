package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

/**
 * Чтобы не плодить копи-пасту отнаследовались от TextElement.
 * Вместо текста вставляем перевод строки.
 */
public class BRElement extends TextElement{


    public BRElement(Element pNodeElement) {
        super(pNodeElement);
    }

    public BRElement(Element pNodeElement, XWPFDocument document) {
        super(pNodeElement, document);
    }

    public BRElement(Element pNodeElement, XWPFDocument document, HtmlStyle htmlStyle) {
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
