package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;

import java.util.List;

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
}
