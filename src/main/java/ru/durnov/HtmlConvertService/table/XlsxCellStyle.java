package ru.durnov.HtmlConvertService.table;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.*;
import ru.durnov.HtmlConvertService.xlsx.XlsxStyle;

/**
 * Параметры стиля таблицы в xlsx-документе;
 */
public class XlsxCellStyle implements XlsxStyle {
    private final XSSFWorkbook xssfWorkbook;
    private final HtmlAlignment htmlAlignment;
    private final HtmlBackGround htmlBackGround;
    private final HtmlFont htmlFont;
    private final HtmlWidth htmlWidth;
    private final TableBorder tableBorder;


    public XlsxCellStyle(Attributes attributes, XSSFWorkbook xssfWorkbook) {
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

    public XlsxCellStyle(Attributes attributes, XSSFWorkbook xssfWorkbook, HtmlFont font) {
        this.xssfWorkbook = xssfWorkbook;
        this.htmlBackGround = new HtmlBackGround(attributes);
        this.htmlAlignment = new HtmlAlignment(attributes);
        this.tableBorder = new TableBorder(attributes);
        this.htmlFont = font;
        this.htmlWidth = new HtmlWidth(attributes);
    }



    public XlsxCellStyle(HtmlFont htmlFont,
                         HtmlAlignment htmlAlignment,
                         HtmlBackGround htmlBackGround,
                         HtmlWidth htmlWidth,
                         TableBorder tableBorder,
                         XSSFWorkbook xssfWorkbook) {
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
        XSSFFont font = xssfWorkbook.createFont();
        new XlsxCellFont(this.htmlFont).setupFont(font);
        xssfCellStyle.setFont(font);
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        xssfCellStyle.setBorderLeft(tableBorder.borderStyle());
        xssfCellStyle.setBorderRight(tableBorder.borderStyle());
        xssfCellStyle.setBorderTop(tableBorder.borderStyle());
        xssfCellStyle.setBorderBottom(tableBorder.borderStyle());
        if (!this.htmlBackGround.value().equals("auto")) {
            xssfCellStyle.setFillForegroundColor(new BackGroundColor(this.htmlBackGround).color());
            xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        if (this.htmlWidth.value() != 15) {
            xssfCellStyle.setWrapText(true);
            xssfCell.getSheet().setColumnWidth(xssfCell.getColumnIndex(), htmlWidth.value() * 256);
        }
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
        xssfCellStyle.setWrapText(true);
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

    @Override
    public String toString() {
        return "XlsxCellStyle{" +
                "xssfWorkbook=" + xssfWorkbook +
                ", htmlAlignment=" + htmlAlignment +
                ", htmlBackGround=" + htmlBackGround +
                ", htmlFont=" + htmlFont +
                ", htmlWidth=" + htmlWidth +
                ", tableBorder=" + tableBorder +
                '}';
    }

    @Override
    public Style withFont(HtmlFont font) {
        return null;
    }

    @Override
    public Style withAlignment(HtmlAlignment alignment) {
        return null;
    }

    @Override
    public Style withBackGround(HtmlBackGround backGround) {
        return null;
    }

    @Override
    public Style withAttributes(Attributes attributes) {
        return null;
    }

    @Override
    public Style withWidth(HtmlWidth htmlWidth) {
        return null;
    }

    @Override
    public HtmlFont font() {
        return this.htmlFont;
    }

    @Override
    public void applyToRun(XWPFRun xwpfRun) {

    }
}
