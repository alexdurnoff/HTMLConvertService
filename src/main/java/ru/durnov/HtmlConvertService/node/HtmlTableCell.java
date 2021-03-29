package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;

/**
 * Класс представляет собой ячейку в html-таблице.
 */
public class HtmlTableCell {
    private final Element htmlTableCell;
    private final Style htmlStyle;

    public HtmlTableCell(Element htmlTableCell, Style style) {
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

    public Style htmlStyle(){
        return htmlStyle;
    }
}
