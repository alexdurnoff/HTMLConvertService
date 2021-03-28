package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import ru.durnov.HtmlConvertService.node.HtmlTableCell;

/**
 * Класс представляет собой ячеку в таблице docx.
 * Инкапсулирует внутри ячейку таблицы html.
 */
public class DocxTableCell {
    private final HtmlTableCell htmlTableCell;
    private final XWPFTableRow xwpfTableRow;

    public DocxTableCell(HtmlTableCell htmlTableCell, XWPFTableRow xwpfTableRow) {
        this.htmlTableCell = htmlTableCell;
        this.xwpfTableRow = xwpfTableRow;
    }


    public void addToXWPFRow() {
        XWPFTableCell xwpfTableCell = xwpfTableRow.createCell();
        XWPFParagraph xwpfParagraph = xwpfTableCell.addParagraph();
        XWPFRun xwpfRun = xwpfParagraph.createRun();
        htmlTableCell.htmlStyle().applyToRun(xwpfRun);
        xwpfRun.setText(htmlTableCell.content());
    }
}
