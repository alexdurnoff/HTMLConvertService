package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.table.MinimumColumnWidth;

public class CellColumnWidth {
    private final Element cellElement;
    private final XSSFCell xssfCell;

    public CellColumnWidth(Element cellElement, XSSFCell xssfCell) {
        this.cellElement = cellElement;
        this.xssfCell = xssfCell;
    }

    public void setUpColumnWidth(){
        xssfCell.getSheet().setColumnWidth(xssfCell.getColumnIndex(), new MinimumColumnWidth(cellElement.text()).columnLength());
    }
}
