package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;

public class XSSFRichSpanStyle {
    private final Element element;
    private final XSSFRichTextString xssfRichTextString;
    private final XSSFCell xssfCell;
    private final FontSize fontSize;
    private final FontWeight fontWeight;

    public XSSFRichSpanStyle(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
        this.xssfRichTextString = xssfCell.getRichStringCellValue();
        this.fontSize = new FontSize(element.attributes());
        this.fontWeight = new FontWeight(element.attributes());
    }

    public void applyToXSSFRichTextString() {
        String elementContent = element.text();
        String cellContent = xssfRichTextString.getString();
        if (cellContent.contains(elementContent)){
            int startIndex = cellContent.lastIndexOf(elementContent);
            int endIndex = startIndex + elementContent.length() - 1;
            XSSFFont xssfFont = xssfCell.getSheet().getWorkbook().createFont();
            xssfFont.setFontHeight(fontSize.value());
            if (fontWeight.value().contains("bold")) xssfFont.setBold(true);
            xssfRichTextString.applyFont(startIndex, endIndex, xssfFont);
        }
    }
}
