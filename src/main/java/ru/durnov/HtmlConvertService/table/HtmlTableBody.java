package ru.durnov.HtmlConvertService.table;

import org.jsoup.nodes.Element;
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

    /**
     * Метод возвращает список html-строк в таблице.
     * @return List<HtmlTableRow>htmlTableRowList;
     */
    public List<HtmlTableRow> htmlTableRowsList(){
        List<HtmlTableRow> htmlTableRowList = new ArrayList<>();
        this.htmlTableElement.getElementsByTag("tr").forEach(element -> {
            htmlTableRowList.add(new HtmlTableRow(
                    element,
                    htmlStyle
            ));
        });
        return htmlTableRowList;
    }

    public Style htmlStyle(){
        return this.htmlStyle;
    }
}
