package ru.durnov.HtmlConvertService.docx;


import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.style.CTDocumentWithPageSize;
import ru.durnov.HtmlConvertService.style.DocxPage;
import ru.durnov.HtmlConvertService.style.Page;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestConvertWithAltChunk {
    private static MyXWPFHtmlDocument createHtmlDoc(XWPFDocument document, String id) throws Exception {
        OPCPackage oPCPackage = document.getPackage();
        PackagePartName partName = PackagingURIHelper.createPartName("/word/" + id + ".html");
        PackagePart part = oPCPackage.createPart(partName, "text/html");
        MyXWPFHtmlDocument myXWPFHtmlDocument = new MyXWPFHtmlDocument(part, id);
        document.addRelation(myXWPFHtmlDocument.getId(), new XWPFHtmlRelation(), myXWPFHtmlDocument);
        return myXWPFHtmlDocument;
    }

    private static class MyXWPFHtmlDocument extends POIXMLDocumentPart {

        private String html;
        private String id;

        private MyXWPFHtmlDocument(PackagePart part, String id) throws Exception {
            super(part);
            //this.html = "<!DOCTYPE html><html><head><style></style><title>HTML import</title></head><body></body>";
            this.html = Files.readString(Path.of("Test/1.html"));
            this.id = id;
        }

        private String getId() {
            return id;
        }

        private String getHtml() {
            return html;
        }

        private void setHtml(String html) {
            this.html = html;
        }

        @Override
        protected void commit() throws IOException {
            PackagePart part = getPackagePart();
            OutputStream out = part.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer.write(html);
            writer.close();
            out.close();
        }

    }

    private final static class XWPFHtmlRelation extends POIXMLRelation {
        private XWPFHtmlRelation() {
            super(
                    "text/html",
                    "http://schemas.openxmlformats.org/officeDocument/2006/relationships/aFChunk",
                    "/word/htmlDoc#.html");
        }
    }

    @Test
    public void test() throws Exception {
        XWPFDocument xwpfDocument = new XWPFDocument();
        Page page = new DocxPage("landshaft");
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        MyXWPFHtmlDocument myXWPFHtmlDocument = createHtmlDoc(xwpfDocument,"htmlDoc1");
        xwpfDocument.getDocument().getBody().addNewAltChunk().setId(myXWPFHtmlDocument.getId());
        xwpfDocument.write(new FileOutputStream("Test/docx/1-2.docx"));
    }




}
