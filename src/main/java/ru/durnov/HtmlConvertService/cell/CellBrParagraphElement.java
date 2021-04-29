package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;

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
        xssfCell.setCellValue(xssfRichTextString.getString());
    }

    @Override
    public void applyToXSSFCell() {

    }
}
