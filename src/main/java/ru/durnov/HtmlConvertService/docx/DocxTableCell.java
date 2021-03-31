package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import ru.durnov.HtmlConvertService.node.HtmlTableCell;

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
        int span = this.htmlTableCell.docxTableCellStyle().tableCellCollSpan().collspan();
        XWPFTableCell xwpfTableCell = new NewXWPFTableCell(xwpfTableRow, cellNumber).createCellByNumber();
        XWPFParagraph xwpfParagraph = xwpfTableCell.addParagraph();
        XWPFRun xwpfRun = xwpfParagraph.createRun();
        htmlTableCell.docxTableCellStyle().htmlStyle().applyToRun(xwpfRun);
        xwpfParagraph.setAlignment(htmlTableCell.docxTableCellStyle().alignment());
        xwpfRun.setText(htmlTableCell.content());
        if (span > 1){
            CTHMerge cthMerge = CTHMerge.Factory.newInstance();
            cthMerge.setVal(STMerge.Enum.forString("continue"));
            xwpfTableCell.getCTTc().addNewTcPr().setHMerge(cthMerge);
            for (int i = 0; i<span; i++) {
                XWPFTableCell xwpfTableCell1 = xwpfTableRow.addNewTableCell();
                xwpfTableCell1.getCTTc().addNewTcPr().setHMerge(cthMerge);
            }
            //xwpfTableCell.getCTTc().addNewTcPr().addNewGridSpan().setVal(BigInteger.valueOf(span));
        }
    }
}
