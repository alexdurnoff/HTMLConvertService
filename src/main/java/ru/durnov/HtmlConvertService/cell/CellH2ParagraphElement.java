package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.H2Style;
import ru.durnov.HtmlConvertService.style.Style;

public class CellH2ParagraphElement extends CellTextParagraphElement{

    public CellH2ParagraphElement(Element element, XSSFCell xssfCell) {
        super(element, xssfCell);
    }

    @Override
    public void addToXSSFCell() {

    }
}
