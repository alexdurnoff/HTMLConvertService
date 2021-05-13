package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;
import ru.durnov.HtmlConvertService.style.HtmlColor;
import ru.durnov.HtmlConvertService.style.HtmlFont;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class XlsxCellFontTest {

    @Test
    void setupFont() {
        Attributes attributes = new Attributes();
        attributes.add("style", "color: #00f000");
        HtmlFont htmlFont = new HtmlFont(
                new FontSize(attributes),
                new FontWeight(attributes),
                new HtmlColor(attributes)
        );
        XlsxCellFont xlsxCellFont = new XlsxCellFont(htmlFont);
        XSSFFont xssfFont = new XSSFFont();
        xlsxCellFont.setupFont(xssfFont);
        Assertions.assertEquals(xssfFont.getFontName(), "Times New Roman");
        Assertions.assertEquals(xssfFont.getFontHeightInPoints(), 12);
    }
}