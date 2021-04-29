package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;

/**
 * Класс  получает строку значения атрибута style типа
 * background-color: #..., и отрезает от нее все дальше решетки,
 * оставляя только hex-числа.
 */
public class ColorValueFromBackGroundString {
    private final String originValue;

    public ColorValueFromBackGroundString(String originValue) {
        if (! originValue.contains("#") || originValue.length() < 2) throw new IllegalArgumentException("Некорректный формат строки для парсинга цвета");
        this.originValue = originValue;
    }


    public String hexValue() {
        return originValue.substring(originValue.indexOf('#') + 1);
    }
}
