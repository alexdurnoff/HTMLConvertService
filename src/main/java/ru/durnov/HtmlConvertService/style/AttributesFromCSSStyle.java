package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

import java.util.List;

/**
 * Класс вытаскивает атрибуты из тэга style.
 * В конструктор получает строку типа {.....}
 */
public class AttributesFromCSSStyle {
    private final String source;

    public AttributesFromCSSStyle(String source) {
        this.source = source;
    }

    public Attributes attributes(){
        Attributes attributes = new Attributes();
        List<String> styleStringList = new KeyValueCSSCollections(source).keyValueStringList();
        new CSSKeyValuePairs(styleStringList).putToAttributes(attributes);
        return attributes;
    }
}
