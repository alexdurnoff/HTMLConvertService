package ru.durnov.HtmlConvertService;

import it.grabz.grabzit.GrabzItClient;
import it.grabz.grabzit.parameters.DOCXOptions;
import org.apache.poi.hwpf.HWPFDocument;
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
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;
import org.w3c.dom.html.HTMLDocument;
import org.w3c.tidy.Tidy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.zip.ZipOutputStream;

public class TestDocxLibraries {

    @Test
    public void testPOI1() throws IOException {
        System.out.println("start testPOI1");
        POIFSFileSystem fileSystem = new POIFSFileSystem();
        DirectoryEntry directoryEntry = fileSystem.getRoot();
        try (OutputStream out = new FileOutputStream("Test/docx/1.doc")
             ; InputStream in = new FileInputStream("Test/1.html")){
            directoryEntry.createDocument(
                    "WordDocument",
                    in
            );
            fileSystem.writeFilesystem(out);
        }

    }

    @Test
    public void testPOI2() throws IOException {
        System.out.println("start testPOI2");
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
        System.out.println("testPOI3");
        POIFSFileSystem fileSystem = new POIFSFileSystem();
        DirectoryEntry directoryEntry = fileSystem.getRoot();
        try (OutputStream out = new FileOutputStream("Test/docx/3.doc")
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
        System.out.println("testPOI4");
        POIFSFileSystem fileSystem = new POIFSFileSystem();
        DirectoryEntry directoryEntry = fileSystem.getRoot();
        try (OutputStream out = new FileOutputStream("Test/docx/4.doc")
             ; InputStream in = new FileInputStream("Test/4.html")){
            directoryEntry.createDocument(
                    "wordDocument",
                    in
            );
            fileSystem.writeFilesystem(out);

        }
    }


}
