package ru.durnov.HtmlConvertService.css;

import ru.durnov.HtmlConvertService.style.border.HtmlTableBorder;

import java.util.List;

@Deprecated
public class TableBorderFromCSSStyle {
    private final List<String> styleStringList;

    public TableBorderFromCSSStyle(String source, List<String> styleStringList) {
        this.styleStringList = styleStringList;

    }

    public HtmlTableBorder tableBorder() {
        return null;
    }


}
