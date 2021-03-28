package ru.durnov.HtmlConvertService.style;

import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class H2AttributesTest {

    @Test
    void attributes() {
        H2Attributes h2Attributes = new H2Attributes();
        Attributes attributes = h2Attributes.attributes();
        String fontSize = attributes.get("style");
        Assertions.assertEquals(fontSize, "font-size: 24px;");
    }
}