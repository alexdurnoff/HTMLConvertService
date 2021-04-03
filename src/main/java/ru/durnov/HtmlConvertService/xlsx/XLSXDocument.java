package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.docx.OutputDocument;
import ru.durnov.HtmlConvertService.table.HtmlTable;
import ru.durnov.HtmlConvertService.table.XlsxCellStyle;

import java.io.FileOutputStream;
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
        Jsoup.parse(content)
                .body()
                .childNodes()
                .forEach(node -> {
            if (node.nodeName().equals("table")){
                Element element = (Element) node;
                new XLSXTable(
                        new HtmlTable(
                               element
                        ),
                        xssfWorkbook,
                        new XlsxCellStyle(
                                element.attributes(),
                                xssfWorkbook
                        )
                ).addToXSSFWorkBook();
            }
        });
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToOutputFile)){
            xssfWorkbook.write(fileOutputStream);
        }
    }
}
