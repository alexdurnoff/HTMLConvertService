package ru.durnov.HtmlConvertService.table;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.HtmlAlignment;
import ru.durnov.HtmlConvertService.style.Style;
import ru.durnov.HtmlConvertService.style.border.HtmlTableBorder;

public class XlsxStyleWithTableBorder {
    private final Style style;
    private final Attribute attribute;

    public XlsxStyleWithTableBorder(Style style, Attribute attribute) {
        this.style = style;
        this.attribute = attribute;
    }

    public Style style(){
        Attributes attributes = new Attributes();
        attributes.add(attribute.getKey(), attribute.getValue());
        try {
            XlsxCellStyle xlsxCellStyle = (XlsxCellStyle) style;
            return xlsxCellStyle.withTableBorder(
                    new HtmlTableBorder(attributes)
            );
        } catch (ClassCastException ignored) {
            return style;
        }
    }
}
