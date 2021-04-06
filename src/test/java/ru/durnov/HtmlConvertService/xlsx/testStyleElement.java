package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.css.CssStyleFromHtml;

import java.io.IOException;

public class testStyleElement {
    private final String source = "Test/for xlsx/2.html";

    @Test
    public void testStyleElementStructure() throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        CssStyleFromHtml cssStyleFromHtml = new CssStyleFromHtml(source);


    }


}
