package ru.durnov.HtmlConvertService.table;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.*;
import ru.durnov.HtmlConvertService.style.border.HtmlTableBorder;

/**
 * Инкапсулирует XlsxCellStyle и атрибут.
 * Возвращает новый XlsxCellStyle в соответствии с параметрами атрибута.
 */
public class XlsxStyleWithAttribute {
    private final XlsxCellStyle xlsxCellStyle;
    private final Attribute attribute;

    public XlsxStyleWithAttribute(XlsxCellStyle xlsxCellStyle, Attribute attribute) {
        this.xlsxCellStyle = xlsxCellStyle;
        this.attribute = attribute;
    }

    public XlsxCellStyle xlsxCellStyle(){
        Attributes attributes = new Attributes();
        attributes.add(attribute.getKey(), attribute.getValue());
        String value = attribute.getValue();
        if (value.contains("text-align")){
            return xlsxCellStyle.withAlignment(new HtmlAlignment(attributes));
        }
        if (value.contains("border")){
            return (XlsxCellStyle) xlsxCellStyle.withTableBorder(
                    new HtmlTableBorder(attributes)
            );
        }
        if (value.contains("font-")){
            return xlsxCellStyle.withFont(
                    new HtmlFont(
                            new FontSize(attributes),
                            new FontWeight(attributes),
                            new HtmlColor(attributes)
                    )
            );
        }
        if (value.contains("color")){
            return (XlsxCellStyle) new XlsxStyleWithColor(xlsxCellStyle, attribute).style();
        }
        return xlsxCellStyle;
    }
}
