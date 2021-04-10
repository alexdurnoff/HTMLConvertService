package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class XSSFBookWithPackagePartTest {

    @Test
    public void tes1() throws IOException, InvalidFormatException {
        String content = Files.readString(Path.of("Test/1.html"));
        XSSFBookWithPackagePart xssfBookWithPackagePart = new XSSFBookWithPackagePart(content);
        XSSFWorkbook workbook = xssfBookWithPackagePart.xssfWorkbook();
        try (FileOutputStream fileOutputStream = new FileOutputStream("Test/xlsx/packagePartTest1.xlsx")){
            workbook.write(fileOutputStream);
        }
    }

}