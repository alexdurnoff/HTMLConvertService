package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import ru.durnov.HtmlConvertService.node.DocxElement;
import ru.durnov.HtmlConvertService.node.HtmlTable;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

/**
 * Таблица в docx-документе
 */
public class DocxTable implements DocxElement {
    private final HtmlTable htmlTable;
    private final XWPFDocument xwpfDocument;
    private final HtmlStyle htmlStyle;


    public DocxTable(HtmlTable htmlTable, XWPFDocument xwpfDocument) {
        this.htmlTable = htmlTable;
        this.xwpfDocument = xwpfDocument;
        this.htmlStyle = htmlTable.htmlStyle();
    }

    @Override
    public void addToXWPFDocument() {
        XWPFTable xwpfTable = xwpfDocument.createTable();
        this.htmlTable.htmlTableRowsList().forEach(htmlTableRow -> {
            new DocxTableRow(
                    htmlTableRow,
                    xwpfTable
            ).addToTableRow();
        });
    }
}
