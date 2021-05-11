package ru.durnov.HtmlConvertService.style;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;

import java.util.HashMap;
import java.util.Map;

public class DOCXBackGroundColor {
    private final HtmlBackGround htmlBackGround;
    private final Map<String, STHighlightColor.Enum> colorMap = new HashMap<>();

    public DOCXBackGroundColor(HtmlBackGround htmlBackGround) {
        this.htmlBackGround = htmlBackGround;
        this.colorMap.put("green", STHighlightColor.GREEN);
        this.colorMap.put("black", STHighlightColor.BLACK);
        this.colorMap.put("blue", STHighlightColor.BLUE);
        this.colorMap.put("red", STHighlightColor.RED);
        this.colorMap.put("yellow", STHighlightColor.YELLOW);
        this.colorMap.put("ffff00", STHighlightColor.YELLOW);
        this.colorMap.put("ff0000", STHighlightColor.RED);
        this.colorMap.put("0000ff", STHighlightColor.BLUE);
    }

    public STHighlightColor.Enum color(){
        return this.colorMap.get(this.htmlBackGround.value());
    }

}
