package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XLSXDocumentTest {
    private final String source = "Test/for xlsx/1.html";
    private final String outputPath = "Test/xlsx/1.xlsx";

    @Test
    void save() throws IOException, InvalidFormatException {
        new XLSXDocument(
                source,
                outputPath,
                new XSSFWorkbook()
        ).save();
    }

    @Test
    public void test2htmlSave() throws IOException, InvalidFormatException {
        new XLSXDocument(
                "Test/for xlsx/2.html",
                "Test/xlsx/2.xlsx",
                new XSSFWorkbook()
        ).save();
    }
}