package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

public class FontSize extends IntegerAttributeValue {

    public FontSize(Attributes attributes) {
        super("font-size:\\s?([0-9]{1,2})p[xt];", 12, attributes);
    }



    @Override
    public String toString() {
        return "fontSize is " + this.value();
    }


}
