package ru.durnov.HtmlConvertService.style;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Параметры обрамления таблицы.
 */
public class TableBorder {
    private final Attributes attributes;
    private final Map<Integer, XWPFTable.XWPFBorderType> docxMap;
    private final Map<Integer, BorderStyle> xlsxMap;


    public TableBorder(Element element) {
        this(element.attributes());
    }

    public TableBorder(Attributes attributes) {
        this.attributes = attributes;
        this.docxMap = new HashMap<>();
        this.xlsxMap = new HashMap<>();
        this.docxMap.put(1, XWPFTable.XWPFBorderType.SINGLE);
        this.docxMap.put(2, XWPFTable.XWPFBorderType.THICK);
        this.docxMap.put(0, XWPFTable.XWPFBorderType.NIL);
        this.xlsxMap.put(0, BorderStyle.NONE);
        this.xlsxMap.put(1, BorderStyle.THIN);
        this.xlsxMap.put(2,BorderStyle.MEDIUM);
        this.xlsxMap.put(3, BorderStyle.THICK);
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
        XWPFTable.XWPFBorderType borderType = docxMap.get(border);
        if (borderType != null) return borderType;
        return XWPFTable.XWPFBorderType.NONE;
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
        BorderStyle borderStyle = xlsxMap.get(border);
        if (borderStyle != null) return borderStyle;
        return BorderStyle.NONE;
    }

    @Override
    public String toString() {
        return "TableBorder{" +
                "attributes=" + attributes +
                '}';
    }
}
