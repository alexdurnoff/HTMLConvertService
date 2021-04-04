package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
/**
 * Класс инкапсулирует ячейку строки таблицы
 * и возвращает число объединенных ячеек.
 */
public class TableRowSpan {
    private final Element htmlCell;


    public TableRowSpan(Element htmlCell) {
        this.htmlCell = htmlCell;
    }

    public int rowspan(){
        int rowspan = 1;
        Attributes attributes = htmlCell.attributes();
        for (Attribute attribute : attributes) {
            if (attribute.getKey().equals("rowspan")) {
                try {
                    rowspan = Integer.parseInt(attribute.getValue());
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return rowspan;
    }
}
