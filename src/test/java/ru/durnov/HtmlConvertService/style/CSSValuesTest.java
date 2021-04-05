package ru.durnov.HtmlConvertService.style;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class CSSValuesTest {
    String source = "border: 1px solid grey;";

    @Test
    void values() {
        List<String> values = new CSSValues(source).values();
        values.forEach(System.out::println);
        Assertions.assertEquals(values.size(), 3);
        Assertions.assertEquals(values.get(0), "1px");
        Assertions.assertEquals(values.get(1), "solid");
        Assertions.assertEquals(values.get(2), "grey");
    }

    @Test
    public void testFindNames(){
        String regExp = "[\\s:]?([0-9a-zA-Z]+)[\\s;]";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(" 1px solid ");
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}