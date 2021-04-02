package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.docx.TestConvertWithAltChunk;
import ru.durnov.HtmlConvertService.style.CTDocumentWithPageSize;
import ru.durnov.HtmlConvertService.style.DocxPage;
import ru.durnov.HtmlConvertService.style.Page;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XWPFDocumentWithPackagePartTest {
    private final String htmlSourcePath = "Test/1.html";

    @Test
    void test1html() throws IOException, InvalidFormatException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                htmlSourcePath,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/1.docx"));
    }

    @Test
    public void test2html() throws InvalidFormatException, IOException {
        String source = "Test/2.html";
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                source,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/2.docx"));

    }

    @Test
    public void test3html() throws InvalidFormatException, IOException {
        String source = "Test/3.html";
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                source,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/3.docx"));

    }

    @Test
    public void test4html() throws InvalidFormatException, IOException {
        String source = "Test/4.html";
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                source,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/4.docx"));

    }




}