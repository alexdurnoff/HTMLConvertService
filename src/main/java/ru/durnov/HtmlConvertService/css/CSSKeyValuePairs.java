package ru.durnov.HtmlConvertService.css;

import org.jsoup.nodes.Attributes;

import java.util.List;

/**
 * Список пар ключ-значение для стилей. Это не мапа, потому что ключи повторяются.
 */
public class CSSKeyValuePairs {
    private final List<String> styleStringList;

    /**
     * @param styleStringList - список строк из CSS-таблицы типа border: 1px solid gray;
     */
    public CSSKeyValuePairs(final List<String> styleStringList) {
        this.styleStringList = styleStringList;
    }

    public void putToAttributes(final Attributes attributes) {
        for (String source : styleStringList) {
            new CSSKeyValuePair(source).putToAttributes(attributes);
        }
    }
}
