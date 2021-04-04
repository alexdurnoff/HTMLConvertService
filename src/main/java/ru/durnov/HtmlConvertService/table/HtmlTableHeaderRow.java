package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontWeight;
import ru.durnov.HtmlConvertService.style.StrongAttaributes;
import ru.durnov.HtmlConvertService.style.Style;

public class HtmlTableHeaderRow extends HtmlTableCell{
    private final String content;
    private final Attributes attributes;


    public HtmlTableHeaderRow(Element element, Style style, String content, Attributes attributes) {
        super(element, style.withAttributes(new StrongAttaributes().attributes()));
        this.content = content;
        this.attributes = attributes;
    }

    @Override
    public String content() {
        return this.content;
    }

    @Override
    public void addTextToXSSFCell(XSSFCell xssfCell) {
        new XlsxCellStyle(
                attributes,
                xssfCell
                        .getRow()
                        .getSheet()
                        .getWorkbook()
        ).withFontWeight(
                new FontWeight(
                        new StrongAttaributes().attributes()
                )
        ).applyToXlsxTableCell(xssfCell);
        xssfCell.getSheet().setColumnWidth(
                xssfCell.getColumnIndex(),
                new MinimumColumnWidth(content).columnLength()
        );
        xssfCell.setCellValue(content);
    }

    @Override
    public boolean isBorderCell() {
        return false;
    }
}
