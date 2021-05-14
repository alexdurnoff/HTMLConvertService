package ru.durnov.HtmlConvertService.table;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.*;
import ru.durnov.HtmlConvertService.style.border.HtmlTableBorder;
import ru.durnov.HtmlConvertService.style.border.XlsxTableBorder;
import ru.durnov.HtmlConvertService.xlsx.XlsxStyle;

import java.util.List;

/**
 * Параметры стиля таблицы в xlsx-документе;
 */
public class XlsxCellStyle implements XlsxStyle {
    private final XSSFWorkbook xssfWorkbook;
    private final HtmlAlignment htmlAlignment;
    private final HtmlBackGround htmlBackGround;
    private final HtmlFont htmlFont;
    private final HtmlWidth htmlWidth;
    private final HtmlTableBorder htmlTableBorder;


    public XlsxCellStyle(Attributes attributes, XSSFWorkbook xssfWorkbook) {
        this.xssfWorkbook = xssfWorkbook;
        this.htmlBackGround = new HtmlBackGround(attributes);
        this.htmlAlignment = new HtmlAlignment(attributes);
        this.htmlTableBorder = new HtmlTableBorder(attributes);
        this.htmlFont = new HtmlFont(
                new FontSize(attributes),
                new FontWeight(attributes),
                new HtmlColor(attributes)
        );
        this.htmlWidth = new HtmlWidth(attributes);
    }

    public XlsxCellStyle(HtmlFont htmlFont,
                         HtmlAlignment htmlAlignment,
                         HtmlBackGround htmlBackGround,
                         HtmlWidth htmlWidth,
                         HtmlTableBorder htmlTableBorder,
                         XSSFWorkbook xssfWorkbook) {
        this.xssfWorkbook = xssfWorkbook;
        this.htmlFont = htmlFont;
        this.htmlAlignment = htmlAlignment;
        this.htmlBackGround = htmlBackGround;
        this.htmlWidth = htmlWidth;
        this.htmlTableBorder = htmlTableBorder;
    }


    @Override
    public void applyToXlsxTableCell(XSSFCell xssfCell) {
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
        new XlsxCellAlignment(this.htmlAlignment).setupXSSFAlignment(xssfCellStyle);
        XSSFFont xssfFont = xssfWorkbook.createFont();
        new XlsxCellFont(this.htmlFont).setupFont(xssfFont);
        xssfCellStyle.setFont(xssfFont);
        new XlsxTableBorder(this.htmlTableBorder).setupBorders(xssfCellStyle);
        new XlsxCellBackGround(this.htmlBackGround).setupBackGround(xssfCellStyle);
        new XlsxColumnWidth(xssfCell, this.htmlWidth).setUpWidth(xssfCellStyle);
        xssfCell.setCellStyle(xssfCellStyle);
    }


    @Override
    public void applyToXlsxSheet(XSSFSheet xssfSheet) {


    }

    @Override
    public void applyToXlsxTableRow(XSSFRow xssfRow) {
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
        new XlsxTableBorder(this.htmlTableBorder).setupBorders(xssfCellStyle);
        xssfCellStyle.setWrapText(true);
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        xssfRow.setRowStyle(xssfCellStyle);
    }

    @Override
    public XlsxStyle withAttributes(Attributes attributes) {
        XlsxCellStyle xlsxStyle1 = this;
        List<Attribute> attributeList = attributes.asList();
        for (Attribute attribute : attributeList) {
            xlsxStyle1 = new XlsxStyleWithAttribute(xlsxStyle1,attribute).xlsxCellStyle();
        }
        return xlsxStyle1;
    }


    @Override
    public XlsxCellStyle withStyle(XlsxStyle xlsxStyle) {
        return null;
    }

    @Override
    public XlsxStyle withTableBorder(HtmlTableBorder htmlTableBorder) {
        return new XlsxCellStyle(
                this.htmlFont,
                this.htmlAlignment,
                this.htmlBackGround,
                this.htmlWidth,
                htmlTableBorder,
                this.xssfWorkbook
                );
    }

    public XlsxCellStyle withFontWeight(FontWeight fontWeight){
        HtmlFont htmlFont = this.htmlFont.withFontWeight(fontWeight);
        return new XlsxCellStyle(
                htmlFont,
                this.htmlAlignment,
                this.htmlBackGround,
                this.htmlWidth,
                this.htmlTableBorder,
                this.xssfWorkbook
        );
    }

    @Override
    public XlsxCellStyle withFont(HtmlFont font) {
        return new XlsxCellStyle(
                font,
                this.htmlAlignment,
                this.htmlBackGround,
                this.htmlWidth,
                this.htmlTableBorder,
                this.xssfWorkbook
        );
    }

    @Override
    public XlsxCellStyle withAlignment(HtmlAlignment alignment) {
        return new XlsxCellStyle(
                this.htmlFont,
                alignment,
                this.htmlBackGround,
                this.htmlWidth,
                this.htmlTableBorder,
                this.xssfWorkbook
        );
    }

    @Override
    public XlsxCellStyle withBackGround(HtmlBackGround backGround) {
        return new XlsxCellStyle(
                this.htmlFont,
                this.htmlAlignment,
                backGround,
                this.htmlWidth,
                this.htmlTableBorder,
                this.xssfWorkbook
        );
    }



    @Override
    public XlsxCellStyle withWidth(HtmlWidth htmlWidth) {
        return new XlsxCellStyle(
                this.htmlFont,
                this.htmlAlignment,
                this.htmlBackGround,
                htmlWidth,
                this.htmlTableBorder,
                this.xssfWorkbook
        );
    }

    @Override
    public HtmlFont font() {
        return this.htmlFont;
    }

    @Override
    public void applyToRun(XWPFRun xwpfRun) {

    }

    @Override
    public String toString() {
        return "XlsxCellStyle{" +
                "xssfWorkbook=" + xssfWorkbook +
                ", htmlAlignment=" + htmlAlignment +
                ", htmlBackGround=" + htmlBackGround +
                ", htmlFont=" + htmlFont +
                ", htmlWidth=" + htmlWidth +
                ", tableBorder=" + htmlTableBorder +
                '}';
    }
}
