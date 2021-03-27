package ru.durnov.HtmlConvertService.style;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringForColorTest {

    @Test
    void colorString() {
        int value = 14;
        System.out.println(new StringForColor(value).colorString());
        value = 255;
        System.out.println(new StringForColor(value).colorString());
        value = 250;
        System.out.println(new StringForColor(value).colorString());
    }
}