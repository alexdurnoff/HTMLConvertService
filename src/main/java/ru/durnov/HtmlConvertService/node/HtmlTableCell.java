package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

/**
 * Класс представляет собой ячейку в html-таблице.
 */
public class HtmlTableCell {
    private final Element htmlTableCell;
    private final HtmlStyle htmlStyle;

    public HtmlTableCell(Element htmlTableCell, HtmlStyle htmlStyle) {
        this.htmlTableCell = htmlTableCell;
        this.htmlStyle = htmlStyle.withAttributes(this.htmlTableCell.attributes());
    }

    public HtmlTableCell(Element htmlTableCell){
        this.htmlTableCell = htmlTableCell;
        this.htmlStyle = new HtmlStyle(this.htmlTableCell.attributes());
    }

    public String content(){
        return htmlTableCell.text();
    }

    public HtmlStyle htmlStyle(){
        return htmlStyle;
    }
}
