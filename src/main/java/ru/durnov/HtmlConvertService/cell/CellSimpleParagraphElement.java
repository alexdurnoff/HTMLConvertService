package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

@Slf4j
public class CellSimpleParagraphElement implements CellParagraphElement{
    private final Element element;
    private final XSSFCell xssfCell;

    public CellSimpleParagraphElement(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
    }

    @Override
    public void addToXSSFCell() {
        HtmlStyle htmlStyle = new HtmlStyle(element.attributes());
        XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
        xssfRichTextString.append(element.text());
        xssfCell.setCellValue(xssfRichTextString.getString());
        htmlStyle.applyToXSSFCell(xssfCell, element);
    }
}
