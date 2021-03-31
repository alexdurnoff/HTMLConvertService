package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Параметры обрамления таблицы.
 */
public class TableBorder {
    private final Attributes attributes;
    private final Map<Integer, XWPFTable.XWPFBorderType> map;


    public TableBorder(Element element) {
        this(element.attributes());
    }

    public TableBorder(Attributes attributes) {
        this.attributes = attributes;
        this.map = new HashMap<>();
        this.map.put(1, XWPFTable.XWPFBorderType.SINGLE);
        this.map.put(0, XWPFTable.XWPFBorderType.NIL);
    }

    public XWPFTable.XWPFBorderType borderType(){
        int border = 0;//Значение по умолчанию
        List<Attribute> attributes = this.attributes.asList();
        for (Attribute attribute : attributes) {
            if (attribute.getKey().equals("border")){
                try {
                    border = Integer.parseInt(attribute.getValue());
                } catch (NumberFormatException ignored) {
                }
            }
        }
        XWPFTable.XWPFBorderType borderType = map.get(border);
        if (borderType != null) return borderType;
        return XWPFTable.XWPFBorderType.NONE;
    }
}
