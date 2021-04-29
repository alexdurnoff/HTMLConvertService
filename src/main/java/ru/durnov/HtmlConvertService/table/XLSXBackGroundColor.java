package ru.durnov.HtmlConvertService.table;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import ru.durnov.HtmlConvertService.style.HtmlBackGround;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс устаннавливает заливку ячейки в xlsx-документе
 */
public class XLSXBackGroundColor {
    private final HtmlBackGround htmlBackGround;
    private final Map<String, XSSFColor> colorMap = new HashMap<>();
    public XLSXBackGroundColor(HtmlBackGround htmlBackGround) {
        this.htmlBackGround = htmlBackGround;
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
        return this.colorMap.get(this.htmlBackGround.value());
    }
}
