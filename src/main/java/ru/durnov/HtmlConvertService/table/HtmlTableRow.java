package ru.durnov.HtmlConvertService.table;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import ru.durnov.HtmlConvertService.style.HtmlFont;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.StrongAttaributes;
import ru.durnov.HtmlConvertService.style.Style;
import ru.durnov.HtmlConvertService.xlsx.XlsxCell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс представляет собой строку в html-таблице.
 */
public class HtmlTableRow {
    private final Element htmlTableRow;
    private final Style style;
    private boolean isHeader;

    public HtmlTableRow(Element htmlTableRow, Style style) {
        this.htmlTableRow = htmlTableRow;
        this.style = style;
    }

    public List<HtmlTableCell> htmlTableCellList(){
        List<HtmlTableCell> htmlTableCellList = new ArrayList<>();
        htmlTableRow.getElementsByTag("th").forEach(element -> {
            htmlTableCellList.add(new HtmlTableCell(
                    element,
                    style.withAttributes(new StrongAttaributes().attributes())
            ));
        });
        htmlTableRow.getElementsByTag("td").forEach(element -> {
            htmlTableCellList.add(
                    new HtmlTableCell(
                            element,
                            style
                    )
            );
        });
        return htmlTableCellList;
    }



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
                        new HtmlStyle(element.attributes())
                );
                if (! htmlTableCell.isBorderCell()) return false;
            }
        }
        Elements elementsTh = this.htmlTableRow.getElementsByTag("th");
        if (elementsTh.size() > 0) return false;
        return true;
    }


}
