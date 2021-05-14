package ru.durnov.HtmlConvertService.table;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.*;
import ru.durnov.HtmlConvertService.style.border.TableBorder;
import ru.durnov.HtmlConvertService.xlsx.XlsxStyle;

import java.util.List;

/**
 * Параметры стиля таблицы в xlsx-документе;
 */
@Slf4j
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
                new FontWeight(attributes),
                new HtmlColor(attributes)
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
        log.debug(toString());
        log.debug(tableBorder.borderStyle().name());
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
        if (tableBorder.borderStyle() != BorderStyle.NONE) {
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, tableBorder.xssfColor());
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.LEFT, tableBorder.xssfColor());
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, tableBorder.xssfColor());
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.TOP, tableBorder.xssfColor());
        }
        if (!this.htmlBackGround.value().equals("auto")) {
            xssfCellStyle.setFillForegroundColor(new XLSXBackGroundColor(this.htmlBackGround).colorFromRGB());
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
        xssfCellStyle.setBorderBottom(this.tableBorder.borderStyle());
        xssfCellStyle.setBorderTop(this.tableBorder.borderStyle());
        xssfCellStyle.setBorderRight(this.tableBorder.borderStyle());
        xssfCellStyle.setBorderLeft(this.tableBorder.borderStyle());
        if (tableBorder.borderStyle() != BorderStyle.NONE) {
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, tableBorder.xssfColor());
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.LEFT, tableBorder.xssfColor());
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, tableBorder.xssfColor());
            xssfCellStyle.setBorderColor(XSSFCellBorder.BorderSide.TOP, tableBorder.xssfColor());
        }
        xssfCellStyle.setWrapText(true);
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        xssfRow.setRowStyle(xssfCellStyle);
    }

    @Override
    public XlsxStyle withAttributes(Attributes attributes) {
        log.debug("Method with attributes invoked");
        XlsxCellStyle xlsxStyle1 = this;
        List<Attribute> attributeList = attributes.asList();
        for (Attribute attribute : attributeList) {
            log.debug(attribute.getKey() + "=" + attribute.getValue());
            if (attribute.getValue().contains("font-")){
                xlsxStyle1 = xlsxStyle1.withFont(
                        new HtmlFont(
                                new FontSize(attributes),
                                new FontWeight(attributes),
                                new HtmlColor(attributes)
                        )
                );
            }
            if (attribute.getValue().contains("text-align")){
                xlsxStyle1 = xlsxStyle1.withAlignment(
                        new HtmlAlignment(attributes)
                );
            }


            if (attribute.getValue().contains("color")){
                log.debug("attribute contains color");
                if (attribute.getValue().contains("background-color")){
                    xlsxStyle1 = xlsxStyle1.withBackGround(
                            new HtmlBackGround(attributes)
                    );
                }
                else {
                    xlsxStyle1 = xlsxStyle1.withFont(
                            new HtmlFont(
                                    new FontSize(attributes),
                                    new FontWeight(attributes),
                                    new HtmlColor(attributes)
                            )
                    );
                }

            }

            if (attribute.getValue().contains("border")){
                xlsxStyle1 = (XlsxCellStyle) xlsxStyle1.withTableBorder(new TableBorder(attributes));
            }

        }
        return xlsxStyle1;
    }


    @Override
    public XlsxCellStyle withStyle(XlsxStyle xlsxStyle) {
        return null;
    }

    @Override
    public XlsxStyle withTableBorder(TableBorder tableBorder) {
        log.debug("Method with table border invoked");
        return new XlsxCellStyle(
                this.htmlFont,
                this.htmlAlignment,
                this.htmlBackGround,
                this.htmlWidth,
                tableBorder,
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
                this.tableBorder,
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
                this.tableBorder,
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
                this.tableBorder,
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
                this.tableBorder,
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
                this.tableBorder,
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
                ", tableBorder=" + tableBorder +
                '}';
    }
}
