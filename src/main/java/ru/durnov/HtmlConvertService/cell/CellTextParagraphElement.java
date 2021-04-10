package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;
import ru.durnov.HtmlConvertService.text.ElementFactory;

import java.io.IOException;

public class CellTextParagraphElement implements CellParagraphElement{
    private final Element element;
    private final Style htmlStyle;
    private final XSSFCell xssfCell;

    public CellTextParagraphElement(Element element, Style htmlStyle, XSSFCell xssfCell) {
        this.element = element;
        this.htmlStyle = htmlStyle.withAttributes(element.attributes());
        this.xssfCell = xssfCell;

    }

    public CellTextParagraphElement(Element element, XSSFCell xssfCell){
        this.element = element;
        this.xssfCell = xssfCell;
        this.htmlStyle = new HtmlStyle(element.attributes());
    }


    @Override
    public void addToXSSFCell() {
        if (! element.ownText().equals("")){
            new CellSimpleParagraphElement(element, xssfCell).addToXSSFCell();
        }
        element.childNodes().forEach(node -> {
            if (node.getClass() == Element.class){
                new CellElementFactory(
                        node,
                        xssfCell,
                        htmlStyle
                ).elementByName().addToXSSFCell();
            }
        });

    }
}
