package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * Класс с назначением, аналогичным назначению NewXWPFTableRow
 */
public class NewXWPFTableCell {
    private final XWPFTableRow xwpfTableRow;
    private final int cellNumber;

    public NewXWPFTableCell(XWPFTableRow xwpfTableRow, int cellNumber) {
        this.xwpfTableRow = xwpfTableRow;
        this.cellNumber = cellNumber;
    }

    public XWPFTableCell createCellByNumber(){
        if (xwpfTableRow.getCell(cellNumber) != null) return xwpfTableRow.getCell(cellNumber);
        return xwpfTableRow.addNewTableCell();
    }
}
