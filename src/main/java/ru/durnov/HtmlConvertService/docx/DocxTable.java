package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.node.DocxElement;
import ru.durnov.HtmlConvertService.node.HtmlTable;
import ru.durnov.HtmlConvertService.node.HtmlTableBody;
import ru.durnov.HtmlConvertService.style.Style;

import java.util.Optional;

/**
 * Таблица в docx документе.
 */
public class DocxTable implements DocxElement {
    private final HtmlTable htmlTable;
    private final XWPFDocument xwpfDocument;
    private final HtmlTableStyle htmlTableStyle;

    public DocxTable(HtmlTable htmlTable, XWPFDocument xwpfDocument) {
        this.htmlTable = htmlTable;
        this.xwpfDocument = xwpfDocument;
        this.htmlTableStyle = htmlTable.htmlTableStyle();
    }

    public DocxTable(HtmlTable htmlTable, XWPFDocument xwpfDocument, Style style){
        this.htmlTable = htmlTable;
        this.xwpfDocument = xwpfDocument;
        this.htmlTableStyle = htmlTable.htmlTableStyle();
    }


    @Override
    public void addToXWPFDocument() {
        Optional<HtmlTableBody> optional = htmlTable.htmlBody();
        optional.ifPresent(htmlTableBody -> new DocxTableBody(
                htmlTableBody,
                xwpfDocument,
                this.htmlTableStyle
        ).addToXWPFDocument());
    }
}
