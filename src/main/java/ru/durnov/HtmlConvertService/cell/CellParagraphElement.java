package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 * Элемент html для добавления в ячейку xlsx-таблицы.
 */
public interface CellParagraphElement {
    void addToXSSFCell(XSSFCell xssfCell);
}
