package ru.durnov.HtmlConvertService.table;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.durnov.HtmlConvertService.docx.HtmlTableStyle;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;

import java.util.Optional;

/**
 * Таблица в html. Создает HtmlTableBody и возвращает стиль таблицы.
 */
public class HtmlTable {
    private final Element element;
    private final Style style;

    public HtmlTable (Element element){
        if (! element.nodeName().equals("table")){
            throw new IllegalArgumentException("element must be table");
        }
        this.element = element;
        this.style = new HtmlStyle(element.attributes());
    }

    public Optional<HtmlTableBody> htmlBody(){
        Elements allElements = element.getAllElements();
        for (Element element1 : allElements) {
            if (element1.nodeName().equals("tbody")){
                return Optional.of(
                        new HtmlTableBody(
                                element1,
                                style.withAttributes(element1.attributes())
                        )
                );
            }
        }
        return Optional.empty();
    }

    public HtmlTableStyle htmlTableStyle(){return new HtmlTableStyle(element, style);}
    public String content(){return element.outerHtml();}

}
