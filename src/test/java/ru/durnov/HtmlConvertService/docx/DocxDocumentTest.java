package ru.durnov.HtmlConvertService.docx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void save() throws IOException {
        this.docxDocument.  save();
    }
}