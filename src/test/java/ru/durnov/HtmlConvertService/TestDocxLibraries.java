package ru.durnov.HtmlConvertService;

import it.grabz.grabzit.GrabzItClient;
import it.grabz.grabzit.parameters.DOCXOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.*;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.*;
import org.docx4j.XmlUtils;
import org.docx4j.convert.in.xhtml.XHTMLImporter;
import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.AltChunkType;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.samples.XhtmlToDocxAndBack;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.tidy.Tidy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.zip.ZipOutputStream;

public class TestDocxLibraries {

    @Test
    public void testPOI1() throws IOException {
        POIFSFileSystem fileSystem = new POIFSFileSystem();
        DirectoryEntry directoryEntry = fileSystem.getRoot();
        try (OutputStream out = new FileOutputStream("Test/docx/1.docx")
             ; InputStream in = new FileInputStream("Test/1.html")){
            directoryEntry.createDocument(
                    "wordDocument",
                    in
            );
            fileSystem.writeFilesystem(out);
        }


    }

    @Test
    public void testPOI2() throws IOException {
        POIFSFileSystem fileSystem = new POIFSFileSystem();
        DirectoryEntry directoryEntry = fileSystem.getRoot();
        try (OutputStream out = new FileOutputStream("Test/docx/2.doc")
             ; InputStream in = new FileInputStream("Test/2.html")){
            directoryEntry.createDocument(
                    "word",
                    in
            );
            fileSystem.writeFilesystem(out);
        }

    }

    @Test
    public void testPOI3() throws IOException {
        POIFSFileSystem fileSystem = new POIFSFileSystem();
        DirectoryEntry directoryEntry = fileSystem.getRoot();
        try (OutputStream out = new FileOutputStream("Test/docx/3.docx")
             ; InputStream in = new FileInputStream("Test/3.html")){
            directoryEntry.createDocument(
                    "wordDocument",
                    in
            );
            fileSystem.writeFilesystem(out);
        }

    }

    @Test
    public void testPOI4() throws IOException {
        POIFSFileSystem fileSystem = new POIFSFileSystem();
        DirectoryEntry directoryEntry = fileSystem.getRoot();
        try (OutputStream out = new FileOutputStream("Test/docx/4.docx")
             ; InputStream in = new FileInputStream("Test/4.html")){
            directoryEntry.createDocument(
                    "wordDocument",
                    in
            );
            fileSystem.writeFilesystem(out);

        }
    }

    @Test
    public
    void testPoi5() throws OpenXML4JException, IOException {
        

    }

    @Test
    public void testPoiWhitDocXFormat() throws IOException, GeneralSecurityException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(Files.readString(Path.of("Test/4.html")));
        FileOutputStream fileOutputStream = new FileOutputStream("Test/docx/6.docx");
        document.write(fileOutputStream);
        fileOutputStream.close();
        document.close();
    }

    @Test
    public void testPoiConvert(){

    }

    @Test
    public void testDocx4j() throws IOException, Docx4JException {
        WordprocessingMLPackage wordprocessingMLPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart documentPart = wordprocessingMLPackage.getMainDocumentPart();
        String xhtml = Files.readString(Paths.get("Test/4.html"));
        documentPart.createParagraphOfText("Paragraph 1");
        documentPart.addAltChunk(AltChunkType.Html,xhtml.getBytes());
        WordprocessingMLPackage mlPackageOut = documentPart.convertAltChunks();
        documentPart.createParagraphOfText("Paragraph 2");
        mlPackageOut.save(new File("Test/docx/docx4j.docx"));
    }

    @Test
    public void testDocx4j2() throws Docx4JException, IOException {
        WordprocessingMLPackage wordprocessingMLPackage = WordprocessingMLPackage.load(new File("Test/docx/template.docx"));
        MainDocumentPart documentPart = wordprocessingMLPackage.getMainDocumentPart();
        String xhtml = Files.readString(Paths.get("Test/4.html"));
        documentPart.createParagraphOfText("Paragraph 1");
        documentPart.addAltChunk(AltChunkType.Html,xhtml.getBytes());
        WordprocessingMLPackage mlPackageOut = documentPart.convertAltChunks();
        documentPart.createParagraphOfText("Paragraph 2");
        mlPackageOut.save(new File("Test/docx/docx4jFromTemplate.docx"));
    }


    @Test
    public void testDocx4j3() throws IOException, Docx4JException {
        WordprocessingMLPackage wordprocessingMLPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart documentPart = wordprocessingMLPackage.getMainDocumentPart();
        String xhtml = Files.readString(Paths.get("Test/4.html"));
        documentPart.addAltChunk(AltChunkType.Html,xhtml.getBytes());
        WordprocessingMLPackage mlPackageOut = documentPart.convertAltChunks();
        mlPackageOut.save(new File("Test/docx/docx4j.docx"));
    }

    @Test
    public void testDocx4j4() throws Docx4JException, IOException {
        WordprocessingMLPackage wordprocessingMLPackage = WordprocessingMLPackage.createPackage();
        String html = Files.readString(Path.of("Test/4.html"));
        String xhtml = convertHtmlToXhtml(html);
        XHTMLImporter xhtmlImporter = new XHTMLImporterImpl(wordprocessingMLPackage);
        xhtmlImporter.setHyperlinkStyle("Hyperlink");
        wordprocessingMLPackage
                .getMainDocumentPart()
                .getContent()
                .addAll(
                        xhtmlImporter.convert(
                                xhtml,
                                null
                        )
                );
        wordprocessingMLPackage.save(new File("Test/docx/docx4jSecondTEst.docx"));
    }

    @Test
    public void testConvertHtmlToXhtml() throws IOException {
        String html = Files.readString(Path.of("Test/4.html"));
        String xhtml = "Test/4.xhtml";
        getXHTMLFromHTML(html, xhtml);
    }

    private String convertHtmlToXhtml(String html) {
        final org.jsoup.nodes.Document document = Jsoup.parse(html);
        document.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
        return document.html();
    }

    private static void getXHTMLFromHTML(String inputFile, String outputFile) throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream(inputFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            Tidy tidy = new Tidy();
            tidy.setXHTML(true);
            tidy.parse(fileInputStream, fileOutputStream);
        }
    }

    @Test
    public void test2() throws Exception {
        String html = Files.readString(Path.of("Test/1.html"));
        GrabzItClient grabzItClient = new GrabzItClient(
                "OGM4OWFlNjY5MDBlNGViMWI4MTU5Y2RmOTliN2U1OWE=",
                "PyBiPz8/Pz92SiRHAWo/P0YjKz8/QUcIPwM/Zj8nQj8="
        );
        DOCXOptions options = new DOCXOptions();
        options.setPageHeight(1080);
        options.setPageWidth(1920);
        grabzItClient.HTMLToDOCX(html, options);
        grabzItClient.SaveTo("Test/docx/grabzit-1.docx");
    }

}
