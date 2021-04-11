package ru.durnov.HtmlConvertService.cell;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.table.XSSFRichStringStyle;

public class CellSpanElement implements CellParagraphElement{
    private final Element element;
    private final XSSFCell xssfCell;

    public CellSpanElement(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
    }

    @Override
    public void addToXSSFCell() {
        XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
        xssfRichTextString.append(element.ownText());
        xssfCell.setCellValue(xssfRichTextString);
        new XSSFRichStringStyle(element, xssfCell).applyToXSSFRichTextString();
    }
}
