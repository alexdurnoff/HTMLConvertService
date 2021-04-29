package ru.durnov.HtmlConvertService.style;

/**
 * Класс будет принимать сжатый вариант hex-значения цвета
 * и возвращать полный
 */
public class FullHexColorValue {
    private final String origin;
    public FullHexColorValue(String origin) {
        if (origin.length() < 3) throw new IllegalArgumentException("Длина компактной строки цвета должна быть не менее 3 :" + origin);
        this.origin = origin;
    }

    public String fullValue() {
        return origin.substring(0,1) +
                origin.substring(0,1) +
                origin.substring(1,2) +
                origin.substring(1,2) +
                origin.substring(2,3) +
                origin.substring(2,3);
    }
}
