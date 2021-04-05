package ru.durnov.HtmlConvertService.style;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
