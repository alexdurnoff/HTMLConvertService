package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.table.HtmlTable;
import ru.durnov.HtmlConvertService.table.HtmlTableRow;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DocxTableRowTest {
    private HtmlTableRow htmlTableRow;
    private DocxTableRow docxTableRow;

    @BeforeEach
    public void setUp() throws IOException {
        String html = Files.readString(Path.of("Test/ont row table.html"));
        Document document = Jsoup.parse(html);
        document.getElementsByTag("table").forEach(element -> {
            HtmlTable htmlTable = new HtmlTable(element);
            XWPFDocument xwpfDocument = new XWPFDocument();
            DocxParagraphTable docxParagraphTable = new DocxParagraphTable(htmlTable,xwpfDocument);
            try {
                docxParagraphTable.addToXWPFDocument();
            } catch (IOException | InvalidFormatException e) {
                e.printStackTrace();
            }
            try {
                xwpfDocument.write(new FileOutputStream("Test/one row table test.docx"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    void addToTableRow() {
    }
}