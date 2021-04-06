package ru.durnov.HtmlConvertService.css;

import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.css.CSSKeyValuePairs;
import ru.durnov.HtmlConvertService.css.KeyValueCSSCollections;

import java.util.List;

/**
 * Класс вытаскивает атрибуты из тэга style.
 * В конструктор получает строку типа <style>.....</\style>
 * Как оказалось, в таком виде атрибуты не нужны.
 * В CSS-таблице стиля для одной key может быть несколько значений,
 * а Attributes - фактически мапа. Нужна другая коллекция.
 */
@Deprecated
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
