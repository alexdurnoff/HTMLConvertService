package ru.durnov.HtmlConvertService.table;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.xssf.usermodel.*;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;
import ru.durnov.HtmlConvertService.style.HtmlColor;
import ru.durnov.HtmlConvertService.style.HtmlFont;

import java.awt.*;
import java.nio.charset.StandardCharsets;

/**
 * Класс инкапсулирует параметры шрифта, полученные из html.
 * Возвращает в единственном методе настроенный шрифт для ячейки.
 */
public class XlsxCellFont {
    private final FontSize fontSize;
    private final FontWeight fontWeight;
    private final HtmlColor htmlColor;

    public XlsxCellFont(HtmlFont htmlFont) {
        this.fontSize = htmlFont.fontSize();
        this.fontWeight = htmlFont.fontWeight();
        this.htmlColor = htmlFont.htmlColor();
    }

    public void setupFont(XSSFFont font) {
        font.setFontHeight(fontSize.value());
        font.setFontHeight(fontSize.value());
        font.setFontName("Times New Roman");
        if (fontWeight.value().contains("bold")) font.setBold(true);
        if (! htmlColor.value().equals("auto")) {
            try {
                font.setColor(
                        new XSSFColor(
                                new Color(
                                        Integer.parseInt(htmlColor.value(), 16)
                                )
                        )
                );
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }


}
