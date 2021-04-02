package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.durnov.HtmlConvertService.docx.OutputDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class XLSXDocument implements OutputDocument {
    private final String sourceFile;
    private final String pathToOutputFile;
    private final XSSFWorkbook xssfWorkbook;

    public XLSXDocument(String sourceFile, String pathToOutputFile, XSSFWorkbook xssfWorkbook) throws IOException {
        this.sourceFile = sourceFile;
        this.pathToOutputFile = pathToOutputFile;
        this.xssfWorkbook = xssfWorkbook;
    }


    @Override
    public void save() throws IOException, InvalidFormatException {
        String content = Files.readString(Path.of(sourceFile));
        Document document = Jsoup.parse(content);
        document.body().childNodes().forEach(node -> {
            if (node.nodeName().equals("table")){

            }
        });

    }
}
