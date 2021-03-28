package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс представляет собой строку в html-таблице.
 */
public class HtmlTableRow {
    private final Element htmlTableRow;
    private final HtmlStyle htmlStyle;


    public HtmlTableRow(Element htmlTableRow, HtmlStyle htmlStyle) {
        this.htmlTableRow = htmlTableRow;
        this.htmlStyle = htmlStyle.withAttributes(this.htmlTableRow.attributes());
    }

    public HtmlTableRow(Element htmlTableRow){
        this.htmlTableRow = htmlTableRow;
        this.htmlStyle = new HtmlStyle(this.htmlTableRow.attributes());
    }

    public List<HtmlTableCell> htmlTableCellList(){
        List<HtmlTableCell> htmlTableCellList = new ArrayList<>();
        this.htmlTableRow.childNodes().forEach(node -> {
            if (node.nodeName().equals("td")){
                htmlTableCellList.add(new HtmlTableCell(
                        (Element) node,
                        htmlStyle
                ));
            }
        });
        return htmlTableCellList;
    };

    public HtmlStyle htmlStyle(){
        return this.htmlStyle;
    }

}
