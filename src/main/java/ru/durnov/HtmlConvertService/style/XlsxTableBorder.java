package ru.durnov.HtmlConvertService.style;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Параметры обрамления xlsx-таблицы,
 * ячеек, строк.
 */
public class XlsxTableBorder {
    private final Attributes attributes;
    private final Map<Integer, BorderStyle> map;

    public XlsxTableBorder(Attributes attributes) {
        this.attributes = attributes;
        this.map = new HashMap<>();
        this.map.put(0, BorderStyle.NONE);
        this.map.put(1, BorderStyle.THIN);
        this.map.put(2,BorderStyle.MEDIUM);
        this.map.put(3, BorderStyle.THICK);
    }

    public XlsxTableBorder(Element element){
        this(element.attributes());
    }

    public BorderStyle borderStyle(){
        int border = 0;
        List<Attribute> attributes = this.attributes.asList();
        for (Attribute attribute : attributes) {
            if (attribute.getKey().equals("border")){
                try {
                    border = Integer.parseInt(attribute.getValue());
                } catch (NumberFormatException ignored) {
                }
            }
        }
        BorderStyle borderStyle = map.get(border);
        if (borderStyle != null) return borderStyle;
        return BorderStyle.NONE;
    }
}
