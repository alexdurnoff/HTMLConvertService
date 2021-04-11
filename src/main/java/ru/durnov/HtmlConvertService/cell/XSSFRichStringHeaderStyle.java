package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;

@Slf4j
public class XSSFRichStringHeaderStyle extends XSSFRichStringStyle{

    public XSSFRichStringHeaderStyle(Element element, XSSFCell xssfCell) {
        super(element, xssfCell);
    }

    @Override
    protected void setFontHeight(XSSFFont xssfFont) {
        if (elementHtmlContainsFontSettings()){
            super.setFontHeight(xssfFont);
        } else {
            xssfFont.setFontHeight(20);
        }
    }
}
