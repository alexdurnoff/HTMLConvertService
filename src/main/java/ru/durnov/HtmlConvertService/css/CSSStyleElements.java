package ru.durnov.HtmlConvertService.css;

import java.util.List;

/**
 * Будет возвращать список CSSStyleElement,
 * на вход получает исходную строку тэга <style></style>
 */
public class CSSStyleElements {
    private final String source;

    public CSSStyleElements(String source) {
        this.source = source;
    }

    public List<CssStyleElement> elementList(){
        return null;
    }
}
