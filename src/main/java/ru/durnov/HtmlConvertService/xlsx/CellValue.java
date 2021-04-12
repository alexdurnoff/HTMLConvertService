package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;

public interface CellValue {
    void setXSSFCellValue(XSSFCell xssfCell);
}
