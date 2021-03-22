package ru.durnov.HtmlConvertService;

import it.grabz.grabzit.GrabzItClient;
import it.grabz.grabzit.parameters.DOCXOptions;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

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
        try (OutputStream out = new FileOutputStream("Test/docx/2.docx")
             ; InputStream in = new FileInputStream("Test/2.html")){
            directoryEntry.createDocument(
                    "wordDocument",
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
