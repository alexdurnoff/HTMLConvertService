package ru.durnov.HtmlConvertService.xlsx;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
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
    public void save() throws IOException {
        log.info("starting XlsxDocument.save sourceFile: " + sourceFile + "; outputFile: " + pathToOutputFile );
        String content;
        try {
            content = Files.readString(Path.of(sourceFile));
        } catch (IOException exception) {
            log.error("Ошибка при сохранении xlsx-файла " + pathToOutputFile);
            log.error(exception.getMessage());
            throw new IOException("Ошибка при чтении входного файла " + sourceFile);
        }
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
        } catch (IOException exception){
            log.error("Ошибка при сохранении xlsx-файла " + pathToOutputFile);
            throw new IOException("Ошибка при сохранении xlsx-файла " + pathToOutputFile);
        }
    }
}
