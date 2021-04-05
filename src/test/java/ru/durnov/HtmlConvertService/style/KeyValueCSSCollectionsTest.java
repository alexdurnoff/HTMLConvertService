package ru.durnov.HtmlConvertService.style;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeyValueCSSCollectionsTest {

    @Test
    public void testSingleTonArrayList(){
        String source = "{\n" +
                "    border: 1px solid grey;\n" +
                "  }";
        List<String> keyValueList = new KeyValueCSSCollections(source).keyValueStringList();
        Assertions.assertEquals(keyValueList.size(), 1);
        Assertions.assertEquals(keyValueList.get(0), "border: 1px solid grey;");
    }

    @Test
    public void testArrayList(){
        String source = "{ border: 1px solid black;" + "\n" +
                "text-align: center;" + "\n" +
                "font-size:16;" +"font-weight: bold;";
        List<String> keyValueList = new KeyValueCSSCollections(source).keyValueStringList();
        Assertions.assertEquals(keyValueList.size(), 4);
        Assertions.assertEquals(keyValueList.get(0), "border: 1px solid black;");
        Assertions.assertEquals(keyValueList.get(1), "text-align: center;");
        Assertions.assertEquals(keyValueList.get(2), "font-size:16;");
        Assertions.assertEquals(keyValueList.get(3), "font-weight: bold;");
    }

}