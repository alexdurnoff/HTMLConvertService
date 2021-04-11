package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;

@Slf4j
/**
 * Тэг b с жирным шрифтом. У него, как я понимаю, детей нет. Поэтому просто добаваляет свой текст
 * и делает жирный шрифт.
 */
public class CellBParagraphElement implements CellParagraphElement{
    private final Element element;
    private final XSSFCell xssfCell;

    public CellBParagraphElement(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
    }

    @Override
    public void addToXSSFCell() {
        XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
        xssfRichTextString.append(element.ownText());
        xssfCell.setCellValue(xssfRichTextString.getString());
        new XSSFRichStringStrongStyle(element, xssfCell).applyToXSSFRichTextString();
    }

    @Override
    public void applyToXSSFCell() {

    }
}
