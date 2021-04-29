package ru.durnov.HtmlConvertService.style;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorValueFromBackGroundStringTest {

    @Test
    void hexValue() {
        String origin = "background-color: #ff0;";
        String hexValue = new ColorValueFromBackGroundString(origin).hexValue();
        Assertions.assertTrue(hexValue.equals("ff0;"));
    }
}