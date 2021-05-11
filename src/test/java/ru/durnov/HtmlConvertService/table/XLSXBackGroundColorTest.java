package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xssf.usermodel.XSSFColor;
import org.jsoup.nodes.Attributes;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.style.HtmlBackGround;

import static org.junit.jupiter.api.Assertions.*;

class XLSXBackGroundColorTest {

    @Test
    void colorFromRGB() {
        Attributes attributes = new Attributes();
        attributes.add("style", "background-color: rgb(255, 255, 0);");
        HtmlBackGround htmlBackGround = new HtmlBackGround(attributes);
        XLSXBackGroundColor xlsxBackGroundColor = new XLSXBackGroundColor(htmlBackGround);
        XSSFColor xssfColors = xlsxBackGroundColor.colorFromRGB();
        System.out.println(xssfColors.getARGBHex());
    }
}