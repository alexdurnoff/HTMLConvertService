package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;

public class HyperlinkCellValue implements CellValue{
    private final Element cellElement;

    public HyperlinkCellValue(Element cellElement) {
        this.cellElement = cellElement;
    }

    @Override
    public void setXSSFCellValue(XSSFCell xssfCell) {
        CreationHelper creationHelper = xssfCell.getSheet().getWorkbook().getCreationHelper();
        Hyperlink hyperlink = creationHelper.createHyperlink(HyperlinkType.URL);
        hyperlink.setAddress(cellElement.attributes().get("href"));
        Font hlinkFont = xssfCell.getSheet().getWorkbook().createFont();
        hlinkFont.setUnderline(Font.U_SINGLE);
        hlinkFont.setColor(IndexedColors.BLUE.getIndex());
        xssfCell.getCellStyle().setFont(hlinkFont);
    }
}
