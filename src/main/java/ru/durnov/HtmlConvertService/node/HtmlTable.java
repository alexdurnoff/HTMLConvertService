package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * Этот класс представляет таблицу Html,
 * но не имплементирует HtmlElement, поскольку
 * надо будет писать как в docx, так и в xlsx.
 * Для записи мы этот элемент завернем.
 */
public class HtmlTable {
    private final Element htmlTableElement;
    private final HtmlStyle htmlStyle;


    public HtmlTable(Element htmlTableElement, HtmlStyle htmlStyle) {
        this.htmlTableElement = htmlTableElement;
        this.htmlStyle = htmlStyle;
    }

    public List<HtmlTableRow> htmlTableRowsList(){
        List<HtmlTableRow> htmlTableRowList = new ArrayList<>();
        this.htmlTableElement.childNodes().forEach(node -> {
            if (node.nodeName().equals("tr")){
                htmlTableRowList.add(new HtmlTableRow(
                        (Element) node,
                        htmlStyle
                ));
            }
        });
        return htmlTableRowList;
    }

    public HtmlStyle htmlStyle(){
        return this.htmlStyle;
    }
}
