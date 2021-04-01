package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import ru.durnov.HtmlConvertService.text.DocxParagraphElement;
import ru.durnov.HtmlConvertService.table.HtmlTableBody;
import ru.durnov.HtmlConvertService.table.HtmlTableRow;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Тело таблицы в docx-документе
 */
public class DocxParagraphTableBody implements DocxParagraphElement {
    private final HtmlTableBody htmlTableBody;
    private final XWPFDocument xwpfDocument;
    private final HtmlTableStyle style;


    public DocxParagraphTableBody(HtmlTableBody htmlTableBody, XWPFDocument xwpfDocument, HtmlTableStyle style) {
        this.htmlTableBody = htmlTableBody;
        this.xwpfDocument = xwpfDocument;
        this.style = style;
    }

    @Override
    public void addToXWPFDocument() {
        XWPFTable xwpfTable = xwpfDocument.createTable();
        this.style.applyToXWPFTable(xwpfTable);
        List<HtmlTableRow> htmlTableRows = this.htmlTableBody
                .htmlTableRowsList()
                .stream()
                .filter(htmlTableRow -> (!htmlTableRow.isBorderRow()))
                .collect(Collectors.toList());
        int rowNumber = 0;
        for (HtmlTableRow htmlTableRow : htmlTableRows){
            new DocxTableRow(
                    htmlTableRow,
                    xwpfTable,
                    rowNumber
            ).addToTableRow();
            rowNumber++;
        }
    }
}
