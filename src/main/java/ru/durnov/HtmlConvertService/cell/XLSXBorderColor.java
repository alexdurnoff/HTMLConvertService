package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.HtmlColor;
import ru.durnov.HtmlConvertService.style.border.BorderAttribute;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс возвращает цвет для границы таблицы
 */
public class XLSXBorderColor {
    //private final HtmlColor htmlColor;
    private final BorderAttribute borderAttribute;
    private final Map<String, XSSFColor> colorMap = new HashMap<>();
    public XLSXBorderColor(BorderAttribute borderAttribute) {
        this.borderAttribute = borderAttribute;
        this.colorMap.put("green", new XSSFColor(IndexedColors.GREEN, new DefaultIndexedColorMap()));
        this.colorMap.put("black", new XSSFColor(IndexedColors.BLACK, new DefaultIndexedColorMap()));
        this.colorMap.put("blue", new XSSFColor(IndexedColors.BLUE, new DefaultIndexedColorMap()));
        this.colorMap.put("red", new XSSFColor(IndexedColors.RED, new DefaultIndexedColorMap()));
        this.colorMap.put("yellow", new XSSFColor(IndexedColors.YELLOW, new DefaultIndexedColorMap()));
        this.colorMap.put("ffff00", new XSSFColor(IndexedColors.YELLOW, new DefaultIndexedColorMap()));
        this.colorMap.put("ff0000", new XSSFColor(IndexedColors.RED, new DefaultIndexedColorMap()));
        this.colorMap.put("0000ff", new XSSFColor(IndexedColors.BLUE, new DefaultIndexedColorMap()));
    }


    public XSSFColor color() {
        XSSFColor xssfColor = this.colorMap.get(this.borderAttribute.color());
        if (xssfColor == null) return new XSSFColor(new DefaultIndexedColorMap());
        return xssfColor;
    }

    public XSSFColor colorFromRGB(){
        XSSFColor xssfColor = null;
        try {
            xssfColor = new XSSFColor(
                    new Color(Integer.parseInt(this.borderAttribute.color(), 16)));
        } catch (NumberFormatException e) {
            return color();
        }
        return xssfColor;

    }
}
