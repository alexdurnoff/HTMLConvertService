package ru.durnov.HtmlConvertService.table;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.xssf.usermodel.XSSFFont;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;
import ru.durnov.HtmlConvertService.style.HtmlFont;

/**
 * Класс инкапсулирует параметры шрифта, полученные из html.
 * Возвращает в единственном методе настроенный шрифт для ячейки.
 */
public class XlsxCellFont {
    private final FontSize fontSize;
    private final FontWeight fontWeight;

    public XlsxCellFont(HtmlFont htmlFont) {
        this.fontSize = htmlFont.fontSize();
        this.fontWeight = htmlFont.fontWeight();
    }

    public Font font() {
        XSSFFont xssfFont = new XSSFFont();
        xssfFont.setFontHeight(fontSize.value());
        xssfFont.setFamily(FontFamily.ROMAN);
        if (fontWeight.value().equals("bold")) xssfFont.setBold(true);
        return xssfFont;
    }
}
