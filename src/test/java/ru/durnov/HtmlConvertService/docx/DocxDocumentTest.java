package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAltChunk;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBodyImpl;
import ru.durnov.HtmlConvertService.style.Page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DocxDocumentTest {
    private DocxDocument docxDocument;

    @BeforeEach
    public void setUp() throws IOException {
        String htmlContent = Files.readString(Path.of("Test/4.html"));
        this.docxDocument = new DocxDocument(htmlContent, "Test/docx/testDocxDocument.docx");
    }


    @Test
    void save() throws IOException, InvalidFormatException {
        this.docxDocument.save();
    }

    @Test
    public void test3HtmlFile() throws IOException, InvalidFormatException {
        String htmlContent = Files.readString(Path.of("Test/3.html"));
        new DocxDocument(htmlContent, "Test/docx/3html with 1920x1080 landscape.docx").save();
    }

    @Test
    public void test2HtmlFile() throws IOException, InvalidFormatException {
        String htmlContent = Files.readString(Path.of("Test/2.html"));
        new DocxDocument(htmlContent, "Test/docx/2html with 1920x1080 landscape.docx").save();
    }

    @Test
    public void test1HtmlFile() throws IOException, InvalidFormatException {
        String htmlContent = Files.readString(Path.of("Test/1.html"));
        new DocxDocument(htmlContent, "Test/docx/1html with 1920x1080 landscape.docx").save();
    }

    @Test
    public void testWithSmallPage() throws IOException, InvalidFormatException {
        String htmlContent = Files.readString(Path.of("Test/1.html"));
        new DocxDocument(
                htmlContent,
                "Test/docx/1html with small landscape.docx",
                new Page() {
                    @Override
                    public int width() {
                        return 1190;
                    }

                    @Override
                    public int heigth() {
                        return 842;
                    }
                }
        ).save();
    }


    @Test
    public void testReadSavedDocument() throws IOException {
        XWPFDocument xwpfDocument =
                new XWPFDocument(new FileInputStream("Test/docx/1html with 1920x1080 landscape.docx"));
        System.out.println(xwpfDocument.getTables().size());
        xwpfDocument.getTables().forEach(xwpfTable -> {
            System.out.println(xwpfTable.getRows().size());
        });

    }

}