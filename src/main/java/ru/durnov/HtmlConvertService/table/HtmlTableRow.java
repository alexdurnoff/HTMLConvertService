package ru.durnov.HtmlConvertService.table;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс представляет собой строку в html-таблице.
 */
public class HtmlTableRow {
    private final Element htmlTableRow;
    private final Style htmlStyle;


    public HtmlTableRow(Element htmlTableRow, Style style) {
        this.htmlTableRow = htmlTableRow;
        this.htmlStyle = style.withAttributes(this.htmlTableRow.attributes());
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

    /**
     * Метод нужен для того, чтобы определить, используется ли строка таблицы для реальных данных,
     * или эта строка нужна для того, чтобы изобразить границу таблицы.
     * @return boolean
     */
    public  boolean isBorderRow(){
        Elements elementsTd = this.htmlTableRow.getElementsByTag("td");
        for (Element element : elementsTd) {
            if (element.nodeName().equals("td")){
                HtmlTableCell htmlTableCell = new HtmlTableCell(
                        element,
                        this.htmlStyle.withAttributes(element.attributes())
                );
                if (! htmlTableCell.isBorderCell()) return false;
            }
        }
        return true;
    }

    public Style htmlStyle(){
        return this.htmlStyle;
    }

}
