package ru.durnov.HtmlConvertService.table;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;
import ru.durnov.HtmlConvertService.style.HtmlFont;

@Slf4j
/**
 * Стиль для части строки в ячейке xlsx-документа.
 */
public class XSSFRichStringStyle {
    private final Element element;
    private final XSSFRichTextString xssfRichTextString;
    private final XSSFCell xssfCell;
    private final FontSize fontSize;
    private final FontWeight fontWeight;

    /**
     * @param element - элемент, из атрибутов которого создаем стиль.
     * @param xssfRichTextString - строка значения ячейки.
     * @param xssfCell - собственно ячейка. Нужна для создания шрифта. Вот так ее приходится таскать.
     */
    public XSSFRichStringStyle(Element element, XSSFRichTextString xssfRichTextString, XSSFCell xssfCell) {
        this.element = element;
        this.xssfRichTextString = xssfRichTextString;
        this.xssfCell = xssfCell;
        this.fontSize = new FontSize(element.attributes());
        this.fontWeight = new FontWeight(element.attributes());
    }

    public XSSFRichStringStyle(Element element, XSSFCell xssfCell){
        this(element, xssfCell.getRichStringCellValue(), xssfCell);
    }

    public void applyToXSSFRichTextString() {
        if (!element.ownText().equals("")) {
            int endIndex = xssfRichTextString.getString().length()-1;
            int startIndex= endIndex - element.ownText().length() + 1;
            XSSFFont xssfFont = xssfCell.getSheet().getWorkbook().createFont();
            xssfFont.setFontHeight(fontSize.value());
            if (fontWeight.value().contains("bold")) xssfFont.setBold(true);
            xssfRichTextString.applyFont(startIndex, endIndex, xssfFont);
        }
    }
}
