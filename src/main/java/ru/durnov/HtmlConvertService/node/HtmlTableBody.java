package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;

import java.util.ArrayList;
import java.util.List;

/**
 * Этот класс представляет таблицу Html,
 * но не имплементирует HtmlElement, поскольку
 * надо будет писать как в docx, так и в xlsx.
 * Для записи мы этот элемент завернем.
 */
public class HtmlTableBody {
    private final Element htmlTableElement;
    private final Style htmlStyle;


    public HtmlTableBody(Element htmlTableElement, Style htmlStyle) {
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

    public Style htmlStyle(){
        return this.htmlStyle;
    }
}
