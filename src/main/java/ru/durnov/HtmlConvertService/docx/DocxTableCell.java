package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.*;
import ru.durnov.HtmlConvertService.table.ElementTableFactory;
import ru.durnov.HtmlConvertService.table.HtmlTableCell;

import java.math.BigInteger;

/**
 * Класс представляет собой ячеку в таблице docx.
 * Инкапсулирует внутри ячейку таблицы html.
 */
public class DocxTableCell {
    private final HtmlTableCell htmlTableCell;
    private final XWPFTableRow xwpfTableRow;
    private final int cellNumber;

    public DocxTableCell(HtmlTableCell htmlTableCell, XWPFTableRow xwpfTableRow, int cellNumber) {
        this.htmlTableCell = htmlTableCell;
        this.xwpfTableRow = xwpfTableRow;
        this.cellNumber = cellNumber;
    }


    public void addToXWPFRow() {
        XWPFTableCell xwpfTableCell = new NewXWPFTableCell(xwpfTableRow, cellNumber).createCellByNumber();
        int collspan = htmlTableCell.docxTableCellStyle().tableCellCollSpan().collspan();
        if (collspan > 1) xwpfTableCell.getCTTc().addNewTcPr().addNewGridSpan().setVal(BigInteger.valueOf(collspan));
        XWPFParagraph xwpfParagraph = xwpfTableCell.addParagraph();
        xwpfParagraph.setWordWrapped(true);
        xwpfParagraph.setAlignment(htmlTableCell.docxTableCellStyle().alignment());
        htmlTableCell.addTextToXWPFTableCell(xwpfParagraph);
        /*XWPFParagraph xwpfParagraph = xwpfTableCell.addParagraph();
        xwpfParagraph.setWordWrapped(true);
        XWPFRun xwpfRun = xwpfParagraph.createRun();
        htmlTableCell.docxTableCellStyle().htmlStyle().applyToRun(xwpfRun);
        xwpfParagraph.setAlignment(htmlTableCell.docxTableCellStyle().alignment());
        xwpfRun.setText(htmlTableCell.content());*/
    }
}
