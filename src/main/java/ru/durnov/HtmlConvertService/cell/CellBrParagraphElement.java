package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;

public class CellBrParagraphElement implements CellParagraphElement{
    private final Element element;
    private final XSSFCell xssfCell;

    public CellBrParagraphElement(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
    }


    @Override
    public void addToXSSFCell() {
        XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
        xssfRichTextString.append("\n");
    }
}
