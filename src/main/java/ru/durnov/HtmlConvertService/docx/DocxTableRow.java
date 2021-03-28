package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import ru.durnov.HtmlConvertService.node.HtmlTableRow;

/**
 * Строка в таблице в docx-документе.
 */
public class DocxTableRow {
    private final HtmlTableRow htmlTableRow;
    private final XWPFTable xwpfTable;

    public DocxTableRow(HtmlTableRow htmlTableRow, XWPFTable xwpfTable) {
        this.htmlTableRow = htmlTableRow;
        this.xwpfTable = xwpfTable;
    }

    public void addToTableRow(){
        XWPFTableRow xwpfTableRow = xwpfTable.createRow();
        htmlTableRow.htmlTableCellList().forEach(htmlTableCell -> {
            new DocxTableCell(
                    htmlTableCell,
                    xwpfTableRow
            ).addToXWPFRow();
        });
    }


}
