package ru.durnov.HtmlConvertService.style;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullHexColorValueTest {

    @Test
    void fullValue() {
        String origin = "ff0;";
        String full = new FullHexColorValue(origin).fullValue();
        System.out.println(full);
    }
}