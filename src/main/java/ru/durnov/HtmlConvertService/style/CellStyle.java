package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;

public interface CellStyle {
    void applyToXWPFCell(XWPFTableCell xwpfTableCell);
}
