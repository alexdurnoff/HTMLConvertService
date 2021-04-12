package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.jsoup.nodes.Element;

public class CellRowHeight {
    private final Element cellElement;
    private final XSSFCell xssfCell;
    public CellRowHeight(Element cellElement, XSSFCell xssfCell) {
        this.cellElement = cellElement;
        this.xssfCell = xssfCell;
    }

    public void setUpRowHeight() {
        if (cellElement.outerHtml().contains("<br>")) {
            XSSFCellStyle xssfCellStyle = xssfCell.getCellStyle();
            xssfCellStyle.setWrapText(true);
            xssfCell.getRow().setHeightInPoints((short) (3*xssfCell.getSheet().getDefaultRowHeightInPoints()));
            xssfCell.setCellStyle(xssfCellStyle);
        }
    }
}
