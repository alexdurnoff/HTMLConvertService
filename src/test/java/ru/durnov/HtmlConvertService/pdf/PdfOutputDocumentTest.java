package ru.durnov.HtmlConvertService.pdf;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PdfOutputDocumentTest {

    @Test
    void save() throws IOException, InvalidFormatException {
        new PdfOutputDocument(
                "Test/1.html",
                "Test/pdf/testPdfOutPutDocument.pdf"
        ).save();
    }
}