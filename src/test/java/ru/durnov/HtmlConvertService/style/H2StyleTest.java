package ru.durnov.HtmlConvertService.style;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class H2StyleTest {

    @Test
    public void toStringTest(){
        H2Style h2Style = new H2Style();
        Assertions.assertTrue(h2Style.toString().contains("fontSize is 24"));
    }

}