package ru.durnov.HtmlConvertService.cell;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class CellSpanElement implements CellParagraphElement{
    private final Element element;
    private final XSSFCell xssfCell;

    public CellSpanElement(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
    }

    @Override
    public void addToXSSFCell() {
        if (!element.ownText().equals("")) {
            XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
            xssfRichTextString.append(element.ownText());
            xssfCell.setCellValue(xssfRichTextString.getString());
        }
        Elements allElements = element.getAllElements();
        allElements.remove(element);
        allElements.forEach(element1 -> {
            new CellElementFactory(element1, xssfCell)
                    .elementByName()
                    .addToXSSFCell();
        });
        new XSSFRichSpanStyle(element, xssfCell).applyToXSSFRichTextString();
    }

    @Override
    public void applyToXSSFCell() {

    }
}
