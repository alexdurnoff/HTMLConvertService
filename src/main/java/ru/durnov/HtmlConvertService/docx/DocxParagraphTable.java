package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import ru.durnov.HtmlConvertService.text.DocxParagraphElement;
import ru.durnov.HtmlConvertService.table.HtmlTable;
import ru.durnov.HtmlConvertService.table.HtmlTableBody;
import ru.durnov.HtmlConvertService.style.Style;

import java.util.Optional;

/**
 * Таблица в docx документе.
 */
public class DocxParagraphTable implements DocxParagraphElement {
    private final HtmlTable htmlTable;
    private final XWPFDocument xwpfDocument;
    private final HtmlTableStyle htmlTableStyle;

    public DocxParagraphTable(HtmlTable htmlTable, XWPFDocument xwpfDocument) {
        this.htmlTable = htmlTable;
        this.xwpfDocument = xwpfDocument;
        this.htmlTableStyle = htmlTable.htmlTableStyle();
    }

    public DocxParagraphTable(HtmlTable htmlTable, XWPFDocument xwpfDocument, Style style){
        this.htmlTable = htmlTable;
        this.xwpfDocument = xwpfDocument;
        this.htmlTableStyle = htmlTable.htmlTableStyle();
    }


    @Override
    public void addToXWPFDocument() {
        Optional<HtmlTableBody> optional = htmlTable.htmlBody();
        optional.ifPresent(htmlTableBody -> new DocxParagraphTableBody(
                htmlTableBody,
                xwpfDocument,
                this.htmlTableStyle
        ).addToXWPFDocument());
    }
}
