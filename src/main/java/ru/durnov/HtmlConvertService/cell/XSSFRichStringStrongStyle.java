package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontSize;

/**
 * Стиль для части строки в ячейке xlsx-документа с жирным шрифтом
 */
public class XSSFRichStringStrongStyle  {
    private final Element element;
    private final XSSFCell xssfCell;
    private final FontSize fontSize;


    public XSSFRichStringStrongStyle(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
        this.fontSize = new FontSize(element.attributes());
    }

    public void applyToXSSFRichTextString() {
        XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
        if (!element.ownText().equals("")) {
            int endIndex = xssfRichTextString.getString().length()-1;
            int startIndex= endIndex - element.text().length() + 1;
            XSSFFont xssfFont = xssfCell.getSheet().getWorkbook().createFont();
            xssfFont.setFontHeight(fontSize.value());
            xssfFont.setBold(true);
            xssfRichTextString.applyFont(startIndex, endIndex, xssfFont);
            xssfCell.setCellValue(xssfRichTextString.getString());
        }
    }
}
