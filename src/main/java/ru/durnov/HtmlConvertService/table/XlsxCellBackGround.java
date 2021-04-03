package ru.durnov.HtmlConvertService.table;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFColor;
import ru.durnov.HtmlConvertService.style.HtmlBackGround;

/**
 * Класс инкапсулирует htmlBackGround и возвращает в единственном
 * методе XSSFColor для BackGroud ячейки.
 */
public class XlsxCellBackGround {
    private final HtmlBackGround htmlBackGround;

    public XlsxCellBackGround(HtmlBackGround htmlBackGround) {
        this.htmlBackGround = htmlBackGround;
    }

    public short indexedValue() {
        if (!this.htmlBackGround.value().equals("auto")) return IndexedColors.YELLOW.index;
        return IndexedColors.AUTOMATIC.index;
    }
}
