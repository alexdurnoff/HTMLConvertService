package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.*;

/**
 * тэг strong. Шрифт всегда жирный
 */
public class StrongParagraphElement extends TextParagraphElement {

    public StrongParagraphElement(Element element, XWPFDocument xwpfDocument, Style style) {
        super (element, xwpfDocument, new StrongFontStyle(style));
    }

    public StrongParagraphElement(Element element, XWPFDocument xwpfDocument){
        super (
                element,
                xwpfDocument,
                new StrongFontStyle(
                        new HtmlStyle(element.attributes()
                ))
        );
    }
}
