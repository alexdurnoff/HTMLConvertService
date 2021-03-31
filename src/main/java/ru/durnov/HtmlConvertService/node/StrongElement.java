package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.*;

/**
 * тэг strong. Шрифт всегда жирный
 */
public class StrongElement extends TextElement {

    public StrongElement(Element element, XWPFDocument xwpfDocument, Style style) {
        super (element, xwpfDocument, new StrongFontStyle(style));
    }

    public StrongElement(Element element, XWPFDocument xwpfDocument){
        super (
                element,
                xwpfDocument,
                new StrongFontStyle(
                        new HtmlStyle(element.attributes()
                ))
        );
    }
}
