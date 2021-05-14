package ru.durnov.HtmlConvertService.table;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import ru.durnov.HtmlConvertService.style.HtmlBackGround;

/**
 * Класс инкапсулирует XlsxBackGroundColor и настраивает стиль ячейки
 */
public class XlsxCellBackGround {
    private final HtmlBackGround htmlBackGround;

    public XlsxCellBackGround(HtmlBackGround htmlBackGround) {
        this.htmlBackGround = htmlBackGround;
    }

    public void setupBackGround(XSSFCellStyle xssfCellStyle){
        if (!this.htmlBackGround.value().equals("auto")) {
            xssfCellStyle.setFillForegroundColor(new XLSXBackGroundColor(this.htmlBackGround).colorFromRGB());
            xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }

    }
}
