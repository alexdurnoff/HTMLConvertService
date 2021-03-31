package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

/**
 * Класс инкапсулирует ячейку строки таблицы
 * и возвращает число объединенных ячеек.
 */
public class TableCellCollSpan {
    private final Element htmlCell;

    public TableCellCollSpan(Element htmlCell) {
        this.htmlCell = htmlCell;
    }

    public int collspan(){
        int colspan = 1;
        Attributes attributes = htmlCell.attributes();
        for (Attribute attribute : attributes) {
            if (attribute.getKey().equals("colspan")) {
                try {
                    colspan = Integer.parseInt(attribute.getValue());
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return colspan;
    }


}
