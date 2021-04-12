package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;

public class XlsxCellValue implements CellValue{
    private final Element element;

    public XlsxCellValue(Element element) {
        this.element = element;
    }

    @Override
    public void setXSSFCellValue(XSSFCell xssfCell) {
        if (element.nodeName().equals("a")) {
            new HyperlinkCellValue(element).setXSSFCellValue(xssfCell);
        } else {
            new ComplexTextCellValue(element).setXSSFCellValue(xssfCell);
        }

    }
}
