package ru.durnov.HtmlConvertService.style;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.css.CSSKey;

class CSSKeyTest {

    @Test
    void name() {
        String source = "border: 1px solid grey;";
        String name = new CSSKey(source).name();
        Assertions.assertEquals(name, "border");
    }
}