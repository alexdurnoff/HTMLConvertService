package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.StrongFontStyle;
import ru.durnov.HtmlConvertService.table.XSSFRichStringStyle;

public class CellStrongParargaphElement extends CellTextParagraphElement{
    public CellStrongParargaphElement(Element element, XSSFCell xssfCell) {
        super(element, xssfCell);
    }

    @Override
    public void addToXSSFCell() {
        super.addToXSSFCell();
        new XSSFRichStringStrongStyle(element,xssfCell).applyToXSSFRichTextString();
    }
}
