package ru.durnov.HtmlConvertService.css;

import org.jsoup.nodes.Attributes;

import java.util.List;

/**
 * Класс получает на вход строку типа ключ-значение, например: border: 1px solid grey
 * и добавляет соответствующие пары ключ-значение в Attributes.
 */
public class CSSKeyValuePair {
    private final String source;

    public CSSKeyValuePair(String source) {
        this.source = source;
    }

    @Deprecated
    public void putToAttributes(Attributes attributes) {
        String key = new CSSKey(source).name();
        List<String> values = new CSSValues(source).values();
        for (String value : values) {
            attributes.put(key, value);
        }
    }


}
