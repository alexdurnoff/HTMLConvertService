package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xwpf.usermodel.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.durnov.HtmlConvertService.style.DocxTableCellStyle;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;

/**
 * Класс представляет собой ячейку в html-таблице.
 */
public class HtmlTableCell {
    private final Element htmlTableCell;
    private final Style htmlStyle;

    public HtmlTableCell (Element htmlTableCell, Style style) {
        this.htmlTableCell = htmlTableCell;
        this.htmlStyle = style.withAttributes(this.htmlTableCell.attributes());
    }

    public HtmlTableCell(Element htmlTableCell){
        this.htmlTableCell = htmlTableCell;
        this.htmlStyle = new HtmlStyle(this.htmlTableCell.attributes());
    }

    public String content(){
        return htmlTableCell.text();
    }

    public void addTextToXWPFTableCell(XWPFParagraph xwpfParagraph){
        XWPFRun xwpfRun = xwpfParagraph.createRun();
        this.htmlStyle.applyToRun(xwpfRun);
        Elements allElements = this.htmlTableCell.getAllElements();
        allElements.remove(this.htmlTableCell);
        allElements.forEach(element -> {
            System.out.println(element);
            new ElementTableFactory(
                    element,
                    xwpfRun,
                    htmlStyle
            ).elementByName().addToXWPFRun();
        });
    }

    public DocxTableCellStyle docxTableCellStyle(){
        return new DocxTableCellStyle(htmlTableCell, htmlStyle);
    }

    /**
     * Метод проверяет наличие атрибута "t" со значенем "z".
     * Нужен для определения назанчения всей строки, содержащей даную ячейку.
     * Если в строке все ячейки окажутся такие, то это строка
     * для изображения границы таблицы, а не данных.
     * @return
     */
    public boolean isBorderCell(){
        Attributes attributes = htmlTableCell.attributes();
        for (Attribute attribute : attributes) {
            if (attribute.getKey().equals("t")){
                if (attribute.getValue().equals("z")) return true;
            }
        }
        return false;
    }

}
