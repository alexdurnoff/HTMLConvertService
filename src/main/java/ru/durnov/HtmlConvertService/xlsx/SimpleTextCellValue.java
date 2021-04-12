package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;

public class SimpleTextCellValue implements CellValue{
    private final Element element;

    public SimpleTextCellValue(Element element) {
        this.element = element;
    }

    @Override
    public void setXSSFCellValue(XSSFCell xssfCell) {
        xssfCell.setCellValue(element.text());
    }
}
