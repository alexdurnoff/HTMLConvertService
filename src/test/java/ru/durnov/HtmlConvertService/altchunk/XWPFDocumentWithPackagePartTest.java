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
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class XWPFDocumentWithPackagePartTest {
    private final String htmlSourcePath = "Test/1.html";

    @Test
    void test1html() throws IOException, InvalidFormatException {
        String content = Files.readString(Path.of(htmlSourcePath));
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                content,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/1-2.docx"));
    }

    @Test
    public void test2html() throws InvalidFormatException, IOException {
        String source = "Test/2.html";
        String content = Files.readString(Path.of(source));
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                content,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/2-2.docx"));

    }

    @Test
    public void test3html() throws InvalidFormatException, IOException {
        String source = "Test/3.html";
        String content = Files.readString(Path.of(source));
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                content,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/3-2.docx"));

    }

    @Test
    public void test4html() throws InvalidFormatException, IOException {
        String source = "Test/4.html";
        String content = Files.readString(Path.of(source));
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                content,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/4-2.docx"));

    }

    @Test
    public void testSmallPage() throws InvalidFormatException, IOException {
        String source = "Test/4.html";
        String content = Files.readString(Path.of(source));
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new Page() {
            @Override
            public int width() {
                return 842;
            }

            @Override
            public int height() {
                return 594;
            }
        };
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                content,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/smallChunk.docx"));
    }




}