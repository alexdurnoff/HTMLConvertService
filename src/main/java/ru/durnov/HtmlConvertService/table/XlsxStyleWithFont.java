package ru.durnov.HtmlConvertService.table;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.*;

public class XlsxStyleWithFont {
    private final Style style;
    private final Attribute attribute;

    public XlsxStyleWithFont(Style style, Attribute attribute) {
        this.style = style;
        this.attribute = attribute;
    }

    public Style style(){
        Attributes attributes = new Attributes();
        attributes.add(attribute.getKey(), attribute.getValue());
        return style.withFont(
                new HtmlFont(
                        new FontSize(attributes),
                        new FontWeight(attributes),
                        new HtmlColor(attributes)
                )
        );
    }
}
