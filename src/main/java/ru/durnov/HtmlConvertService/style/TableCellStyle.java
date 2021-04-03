package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.text.CellAllignment;

/**
 * Класс отвечает за форматирование ячейки таблицы
 */
public class TableCellStyle {
    private final Element htmlTableCell;
    private final Style htmlStyle;


    public TableCellStyle(Element htmlTableCell, Style htmlStyle) {
        this.htmlTableCell = htmlTableCell;
        this.htmlStyle = htmlStyle;
    }

    public Style htmlStyle(){
        return htmlStyle;
    }

    public ParagraphAlignment alignment(){
        return new CellAllignment(htmlTableCell.attributes()).paragraphAlignment();
    }

    public TableCellCollSpan tableCellCollSpan(){
        return new TableCellCollSpan(this.htmlTableCell);
    }
}
