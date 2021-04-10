package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

public class CellSimpleParagraphElement implements CellParagraphElement{
    private final Element element;

    public CellSimpleParagraphElement(Element element) {
        this.element = element;
    }

    @Override
    public void addToXSSFCell(XSSFCell xssfCell) {
        HtmlStyle htmlStyle = new HtmlStyle(element.attributes());
        XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
        xssfRichTextString.append(element.text());
        htmlStyle.applyToXSSFCell(xssfCell, element);
    }
}
