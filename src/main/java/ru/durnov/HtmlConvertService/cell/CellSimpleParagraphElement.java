package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

@Slf4j
public class CellSimpleParagraphElement implements CellParagraphElement{
    private final Element element;
    private final XSSFRichTextString xssfRichTextString;

    public CellSimpleParagraphElement(Element element, XSSFRichTextString xssfRichTextString) {
        this.element = element;
        this.xssfRichTextString = xssfRichTextString;
    }

    @Override
    public void addToXSSFCell() {
        xssfRichTextString.append(element.text());
    }
}
