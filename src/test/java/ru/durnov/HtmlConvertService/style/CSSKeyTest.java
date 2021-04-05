package ru.durnov.HtmlConvertService.style;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSSKeyTest {

    @Test
    void name() {
        String source = "border: 1px solid grey;";
        String name = new CSSKey(source).name();
        Assertions.assertEquals(name, "border");
    }
}