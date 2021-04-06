package ru.durnov.HtmlConvertService.css;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.durnov.HtmlConvertService.style.*;
import ru.durnov.HtmlConvertService.table.XlsxCellStyle;
import ru.durnov.HtmlConvertService.xlsx.XlsxStyle;

import java.io.IOException;

/**
 * Класс будет возвращать XlsxStyle из файла. Инкапсулирует строку - путь к файлу.
 */

@Deprecated
public class CssStyleFromHtml {

    private final String source;

    public CssStyleFromHtml(String source) {
        this.source = source;
    }


}
