package ru.durnov.HtmlConvertService.table;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.*;
import ru.durnov.HtmlConvertService.xlsx.XlsxStyle;

import java.util.List;

/**
 * Параметры стиля таблицы в xlsx-документе;
 */
public class XlsxCellStyle extends HtmlStyle implements XlsxStyle {
    private final XSSFWorkbook xssfWorkbook;
    private final HtmlAlignment htmlAlignment;
    private final HtmlBackGround htmlBackGround;
    private final HtmlFont htmlFont;
    private final HtmlWidth htmlWidth;
    private final TableBorder tableBorder;

    public XlsxCellStyle(Attributes attributes, XSSFWorkbook xssfWorkbook) {
        super(attributes);
        this.xssfWorkbook = xssfWorkbook;
        this.htmlBackGround = new HtmlBackGround(attributes);
        this.htmlAlignment = new HtmlAlignment(attributes);
        this.tableBorder = new TableBorder(attributes);
        this.htmlFont = new HtmlFont(
                new FontSize(attributes),
                new FontWeight(attributes)
        );
        this.htmlWidth = new HtmlWidth(attributes);
    }

    public XlsxCellStyle(HtmlFont htmlFont,
                         HtmlAlignment htmlAlignment,
                         HtmlBackGround htmlBackGround,
                         HtmlWidth htmlWidth,
                         TableBorder tableBorder,
                         XSSFWorkbook xssfWorkbook) {
        super(htmlFont, htmlAlignment, htmlBackGround, htmlWidth);
        this.xssfWorkbook = xssfWorkbook;
        this.htmlFont = htmlFont;
        this.htmlAlignment = htmlAlignment;
        this.htmlBackGround = htmlBackGround;
        this.htmlWidth = htmlWidth;
        this.tableBorder = tableBorder;
    }


    @Override
    public void applyToXlsxTableCell(XSSFCell xssfCell) {
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
        xssfCellStyle.setAlignment(new XlsxCellAlignment(this.htmlAlignment).horizontalAlignment());
        xssfCellStyle.setFont(new XlsxCellFont(this.htmlFont).font());
        xssfCellStyle.setFillBackgroundColor(new XlsxCellBackGround(this.htmlBackGround).indexedValue());
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        xssfCellStyle.setWrapText(true);
        xssfCellStyle.setBorderLeft(tableBorder.borderStyle());
        xssfCellStyle.setBorderRight(tableBorder.borderStyle());
        xssfCellStyle.setBorderTop(tableBorder.borderStyle());
        xssfCellStyle.setBorderBottom(tableBorder.borderStyle());
        xssfCellStyle.setFillBackgroundColor(new BackGroundColor(htmlBackGround).color());
        xssfCell.setCellStyle(xssfCellStyle);
    }


    @Override
    public void applyToXlsxSheet(XSSFSheet xssfSheet) {


    }

    @Override
    public void applyToXlsxTableRow(XSSFRow xssfRow) {
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
        xssfCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        xssfCellStyle.setBorderBottom(this.tableBorder.borderStyle());
        xssfCellStyle.setBorderTop(this.tableBorder.borderStyle());
        xssfCellStyle.setBorderRight(this.tableBorder.borderStyle());
        xssfCellStyle.setBorderLeft(this.tableBorder.borderStyle());
        xssfRow.setRowStyle(xssfCellStyle);
    }


    @Override
    public XlsxCellStyle withStyle(XlsxStyle xlsxStyle) {
        return null;
    }

    public XlsxCellStyle withFontWeight(FontWeight fontWeight){
        HtmlFont htmlFont = this.htmlFont.withFontWeight(fontWeight);
        return new XlsxCellStyle(
                htmlFont,
                this.htmlAlignment,
                this.htmlBackGround,
                this.htmlWidth,
                this.tableBorder,
                this.xssfWorkbook
        );
    }
}
