package ru.durnov.HtmlConvertService.style;

import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class HtmlFont {
    private final FontSize fontSize;
    private final FontWeight fontWeight;

    public HtmlFont(FontSize fontSize, FontWeight fontWeight) {
        this.fontSize = fontSize;
        this.fontWeight = fontWeight;
    }

    public FontSize fontSize(){
        return this.fontSize;
    }

    public FontWeight fontWeight(){
       return this.fontWeight;
    }

    public HtmlFont withFontSize(FontSize fontSize){
        return new HtmlFont(fontSize, this.fontWeight);
    }

    public HtmlFont withFontWeight(FontWeight fontWeight){
        return new HtmlFont(this.fontSize, fontWeight);
    }

    @Override
    public String toString() {
        return "HtmlFont{" +
                "fontSize=" + fontSize +
                ", fontWeight=" + fontWeight +
                '}';
    }



}
