package ru.durnov.HtmlConvertService.style;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ColorValueWithOutSharpTest {

    @Test
    void hexValue() {
        String origin = "background-color: #ff0;";
        String hexValue = new ColorValueWithOutSharp(origin).hexValue();
        Assertions.assertTrue(hexValue.equals("ff0;"));
    }
}