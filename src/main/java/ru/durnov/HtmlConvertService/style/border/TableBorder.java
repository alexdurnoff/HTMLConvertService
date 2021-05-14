package ru.durnov.HtmlConvertService.style.border;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.cell.XLSXBorderColor;
import ru.durnov.HtmlConvertService.style.HtmlColor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Параметры обрамления таблицы.
 */
@Slf4j
public class TableBorder {
    private final Attributes attributes;
    private final Map<Integer, XWPFTable.XWPFBorderType> docxMap;



    public TableBorder(Element element) {
        this(element.attributes());
    }

    public TableBorder(Attributes attributes) {
        this.attributes = attributes;
        this.docxMap = new HashMap<>();
        this.docxMap.put(1, XWPFTable.XWPFBorderType.SINGLE);
        this.docxMap.put(2, XWPFTable.XWPFBorderType.THICK);
        this.docxMap.put(0, XWPFTable.XWPFBorderType.NIL);
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
        return new HtmlBorderStyle(
                new BorderAttribute(attributes)
        ).borderStyle();
    }

    public XSSFColor xssfColor(){
        return new XLSXBorderColor(
                new BorderAttribute(attributes)
        ).colorFromRGB();
    }

    @Override
    public String toString() {
        return "TableBorder{" +
                "attributes=" + attributes +
                "border style=" + this.borderStyle().name() +
                '}';
    }
}
