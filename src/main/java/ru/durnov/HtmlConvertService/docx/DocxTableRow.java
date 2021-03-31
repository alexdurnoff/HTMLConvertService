package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import ru.durnov.HtmlConvertService.node.HtmlTableCell;
import ru.durnov.HtmlConvertService.node.HtmlTableRow;
import ru.durnov.HtmlConvertService.style.TableCellCollSpan;

import java.util.List;

/**
 * Строка в таблице в docx-документе.
 */
public class DocxTableRow {
    private final HtmlTableRow htmlTableRow;
    private final XWPFTable xwpfTable;
    private final int rowNumber;

    /**
     * Как оказалось, обязательно нужен индекс строки,
     * поскольку таблица создается с пустой первой строкой и пустым первым столбцом.
     * Нам надо опрределиться, брать ли первую строку, или создавать новую.
     * Поэтому без индекса никак.
     * @param htmlTableRow HtmlTableRow, инкапсулирует элемент "tr".
     * @param xwpfTable XWPFTable - таблица, куда пишутся данные.
     * @param rowNumber - номер добавляемой строки.
     */
    public DocxTableRow(HtmlTableRow htmlTableRow, XWPFTable xwpfTable, int rowNumber) {
        this.htmlTableRow = htmlTableRow;
        this.xwpfTable = xwpfTable;
        this.rowNumber = rowNumber;
    }

    public void addToTableRow(){
        XWPFTableRow xwpfTableRow = new NewXWPFTableRow(xwpfTable, rowNumber).createRowByNumber();
        List<HtmlTableCell> htmlTableCells = htmlTableRow.htmlTableCellList();
        for (int i = 0; i < htmlTableCells.size(); i++) {
            new DocxTableCell(
                    htmlTableCells.get(i),
                    xwpfTableRow,
                    i
            ).addToXWPFRow();
        }
    }


}
