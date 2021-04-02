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
    void xwpfDocument() throws InvalidFormatException, IOException {
        XWPFDocument xwpfDocument = new XWPFDocumentWithPackagePart(
                htmlSourcePath,
                new Page() {
                    @Override
                    public int width() {
                        return 1920;
                    }

                    @Override
                    public int heigth() {
                        return 1080;
                    }
                }
        ).xwpfDocument();
        xwpfDocument.write(new FileOutputStream("Test/docx/testXWPFDocumentWithPart.docx"));
    }

    @Test
    void test2() throws IOException, InvalidFormatException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        new XWPFDocumentWithPackagePart(
                htmlSourcePath,
                xwpfDocument
        ).xwpfDocument().write(new FileOutputStream("Test/docx/testXWPFDocumentWithPart.docx"));
    }




}