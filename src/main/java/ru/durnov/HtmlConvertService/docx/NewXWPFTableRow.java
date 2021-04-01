package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * Класс для создания строки в таблице. Нужен,
 * поскольку таблица создается изначально с одной строкой
 * и одной ячейкой в строке. Если в таблице одна строка,
 * то класс возвращает эту строку. В противном случае создает новую строку.
 */
public class NewXWPFTableRow {
    private final XWPFTable xwpfTable;
    private final int rowNumber;

    public NewXWPFTableRow(XWPFTable xwpfTable, int rowNumber) {
        this.xwpfTable = xwpfTable;
        this.rowNumber = rowNumber;
    }


    public XWPFTableRow createRowByNumber(){
       /* if(rowNumber == 0) return xwpfTable.getRow(0);
        return xwpfTable.createRow();*/
        XWPFTableRow xwpfTableRow = xwpfTable.getRow(rowNumber);
        if (xwpfTableRow == null) return xwpfTable.createRow();
        return xwpfTableRow;
    }
}
