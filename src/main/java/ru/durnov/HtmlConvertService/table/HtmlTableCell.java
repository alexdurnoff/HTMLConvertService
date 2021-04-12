package ru.durnov.HtmlConvertService.table;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xwpf.usermodel.*;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import ru.durnov.HtmlConvertService.cell.*;
import ru.durnov.HtmlConvertService.style.TableCellStyle;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;
import ru.durnov.HtmlConvertService.xlsx.XlsxStyle;

import java.util.List;

@Slf4j
/**
 * Класс представляет собой ячейку в html-таблице.
 */
public class HtmlTableCell {
    private final Element cellElement;
    private final Style htmlStyle;

    public HtmlTableCell (Element element, Style style) {
        this.cellElement = element;
        this.htmlStyle = style.withAttributes(this.cellElement.attributes());
    }

    public HtmlTableCell(Element cellElement){
        this.cellElement = cellElement;
        this.htmlStyle = new HtmlStyle(this.cellElement.attributes());
    }
    @Deprecated
    public String content(){
        return cellElement.text();
    }

    public void addTextToXWPFTableCell(XWPFParagraph xwpfParagraph){
        XWPFRun xwpfRun = xwpfParagraph.createRun();
        this.htmlStyle.applyToRun(xwpfRun);
        Elements allElements = this.cellElement.getAllElements();
        allElements.remove(this.cellElement);
        allElements.forEach(element -> {
            new ElementTableFactory(
                    element,
                    xwpfRun,
                    htmlStyle
            ).elementByName().addToXWPFRun();
        });
    }

    public void addTextToXSSFCell(XSSFCell xssfCell, XlsxStyle xlsxStyle){
        xlsxStyle.withAttributes(cellElement.attributes()).applyToXlsxTableCell(xssfCell);
        xssfCell.getSheet().setColumnWidth(xssfCell.getColumnIndex(), new MinimumColumnWidth(cellElement.text()).columnLength());
        xssfCell.setCellValue(
                new XSSFRichTextStringFromElement(
                        cellElement,
                        xssfCell
                ).xssfRichTextString()
        );
        if (cellElement.outerHtml().contains("<br>")) {
            XSSFCellStyle xssfCellStyle = xssfCell.getCellStyle();
            xssfCellStyle.setWrapText(true);
            xssfCell.getRow().setHeightInPoints((short) (3*xssfCell.getSheet().getDefaultRowHeightInPoints()));
            xssfCell.setCellStyle(xssfCellStyle);
        }
    }

    public TableCellStyle docxTableCellStyle(){
        return new TableCellStyle(cellElement, htmlStyle);
    }

    /**
     * Метод проверяет наличие атрибута "t" со значенем "z".
     * Нужен для определения назанчения всей строки, содержащей даную ячейку.
     * Если в строке все ячейки окажутся такие, то это строка
     * для изображения границы таблицы, а не данных.
     * @return
     */
    public boolean isBorderCell(){
        Attributes attributes = cellElement.attributes();
        for (Attribute attribute : attributes) {
            if (attribute.getKey().equals("t")){
                if (attribute.getValue().equals("z")) return true;
            }
        }
        return false;
    }



}
