package ru.durnov.HtmlConvertService.css;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Возвращает ключ элемента из строки типа border: 1px solid grey;
 */
public class CSSKey {
    private final String source;

    public CSSKey(String source) {
        this.source = source;
    }

    public String name() {
        String nameRegExp = "[a-z\\-]{1,}:";
        Pattern pattern = Pattern.compile(nameRegExp);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) return matcher.group().replace(":", "");
        return "";
    }
}
