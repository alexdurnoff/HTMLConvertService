package ru.durnov.HtmlConvertService.style;

public class HtmlFont {
    private final FontSize fontSize;
    private final FontWeight fontWeight;
    private final HtmlColor htmlColor;

    public HtmlFont(FontSize fontSize, FontWeight fontWeight, HtmlColor htmlColor) {
        this.fontSize = fontSize;
        this.fontWeight = fontWeight;
        this.htmlColor = htmlColor;
    }

    public FontSize fontSize(){
        return this.fontSize;
    }

    public FontWeight fontWeight(){
       return this.fontWeight;
    }

    public HtmlColor htmlColor(){return this.htmlColor;}

    public HtmlFont withFontSize(FontSize fontSize){
        return new HtmlFont(fontSize, this.fontWeight, this.htmlColor);
    }

    public HtmlFont withFontWeight(FontWeight fontWeight){
        return new HtmlFont(this.fontSize, fontWeight, this.htmlColor);
    }

    public HtmlFont withColor(HtmlColor htmlColor){
        return new HtmlFont(this.fontSize, this.fontWeight, htmlColor);
    }

    @Override
    public String toString() {
        return "HtmlFont{" +
                "fontSize=" + fontSize +
                ", fontWeight=" + fontWeight +
                ", fontColor= " + htmlColor.value() +
                '}';
    }



}
