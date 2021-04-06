package ru.durnov.HtmlConvertService.css;

import org.jsoup.nodes.Attributes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс на вход подучает строку типа {...}
 * и выдает на выход список строк ключ-значение типа, например, border: 1px grey;
 */
public class KeyValueCSSCollections {
    private final String styleString;
    private final String nameRegExp = "([a-z\\-]{1,}:)";

    public KeyValueCSSCollections(String styleString) {
        this.styleString = styleString;
    }

    public List<String> keyValueStringList() {
        List<String> keyValueList = new ArrayList<>();
        Pattern namePattern = Pattern.compile(nameRegExp);
        Matcher nameMatcher = namePattern.matcher(styleString);
        while (nameMatcher.find()){
            String name = nameMatcher.group();
            Pattern keyPlusValuePattern = Pattern.compile(name + ".+?;");
            Matcher keyValueMatcher = keyPlusValuePattern.matcher(styleString);
            while (keyValueMatcher.find()) {
                keyValueList.add(keyValueMatcher.group());
            }
        }
        return keyValueList;
    }
}
