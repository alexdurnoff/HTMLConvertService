package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.altchunk.XSSFBookWithPackagePart;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class testEmbedToWorkBook {

    @Test
    public void test1() throws IOException {
        XSSFBookWithPackagePart xssfBookWithPackagePart = new XSSFBookWithPackagePart(
                Files.readString(Path.of("Test/3.html"))
        );
        try (FileOutputStream fileOutputStream = new FileOutputStream("Test/xlsx/testEmbedHtml1.xls")){
            xssfBookWithPackagePart.xssfWorkbook().write(fileOutputStream);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
