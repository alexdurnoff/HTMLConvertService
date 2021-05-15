package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.cell.XSSFRichTextStringFromElement;

public class ComplexTextCellValue implements CellValue{
    private final Element cellElement;

    public ComplexTextCellValue(Element cellElement) {
        this.cellElement = cellElement;
    }

    @Override
    public void setXSSFCellValue(XSSFCell xssfCell) {
        xssfCell.setCellValue(
                new XSSFRichTextStringFromElement(
                        cellElement,
                        xssfCell
                ).xssfRichTextStringByOrder()
        );

    }
}
