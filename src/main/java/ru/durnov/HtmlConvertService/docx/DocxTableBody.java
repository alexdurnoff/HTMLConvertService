package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import ru.durnov.HtmlConvertService.node.DocxElement;
import ru.durnov.HtmlConvertService.node.HtmlTableBody;
import ru.durnov.HtmlConvertService.node.HtmlTableRow;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;

import java.util.List;

/**
 * Тело таблицы в docx-документе
 */
public class DocxTableBody implements DocxElement {
    private final HtmlTableBody htmlTableBody;
    private final XWPFDocument xwpfDocument;
    private final HtmlTableStyle style;


    public DocxTableBody(HtmlTableBody htmlTableBody, XWPFDocument xwpfDocument, HtmlTableStyle style) {
        this.htmlTableBody = htmlTableBody;
        this.xwpfDocument = xwpfDocument;
        this.style = style;
    }

    @Override
    public void addToXWPFDocument() {
        XWPFTable xwpfTable = xwpfDocument.createTable();
        this.style.applyToXWPFTable(xwpfTable);
        List<HtmlTableRow> htmlTableRows = this.htmlTableBody.htmlTableRowsList();
        for (int i = 0; i < htmlTableRows.size(); i++){
            new DocxTableRow(
                   htmlTableRows.get(i),
                    xwpfTable,
                    i
            ).addToTableRow();
        }
    }
}
