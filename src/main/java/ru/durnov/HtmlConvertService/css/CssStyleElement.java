package ru.durnov.HtmlConvertService.css;

import ru.durnov.HtmlConvertService.style.border.HtmlTableBorder;
import ru.durnov.HtmlConvertService.xlsx.XlsxStyle;

import java.util.List;

public class CssStyleElement {
    private final String source;
    private final String elementName;

    /**
     * Представляет собой имя элемента, к которому применяется стиль и список пар ключ-значение стиля.
     * @param source - входная строка. Вообще говоря, должна строго соответствовать шаблону типа
     * td {....};
     */
    public CssStyleElement(String source) {
        this.source = source;
        this.elementName = new ElementNameFromSourceString(source).elementName();
    }

    /**
     * Настраивает xlsx-стиль. Ну я на это надеюсь...
     * @param xlsxStyle
     */
    public void applyToXlsxStyle(XlsxStyle xlsxStyle){
        List<String> styleStringList =
                new KeyValueCSSCollections(source)
                        .keyValueStringList();
        HtmlTableBorder htmlTableBorder = new TableBorderFromCSS(styleStringList).tableBorder();



    }


}
