package ru.durnov.HtmlConvertService.css;

import ru.durnov.HtmlConvertService.style.HtmlWidth;

public class HtmlWidthFromCSSStyle {
    private final String source;
    private final String weightRegExp = "border:\\s?.*([0-9]{1,2}px)";
    private final String type = "border:\\s?.*([a-zA-z]{1,}\\s)";
    private final String color = "border:\\s?.*[a-zA-z]{1,}\\s([a-zA-Z]{1,})";


    public HtmlWidthFromCSSStyle(String source) {
        this.source = source;
    }

    public HtmlWidth width() {
        return null;
    }
}
