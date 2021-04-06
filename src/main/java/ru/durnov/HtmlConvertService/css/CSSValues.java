package ru.durnov.HtmlConvertService.css;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Возвращает список значений, получая на вход строку типа border: 1px solid grey;
 */
public class CSSValues {
    private final String source;

    public CSSValues(String source) {
        this.source = source;
    }

    public List<String> values() {
        System.out.println(source);
        List<String> values = new ArrayList<>();
        String valueRegExp = "([0-9a-zA-Z]+)[\\s;]";
        Pattern pattern = Pattern.compile(valueRegExp);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()){
            values.add(matcher.group().trim().replace(";",""));
        }
        return values;
    }
}
