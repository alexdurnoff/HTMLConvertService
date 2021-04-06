package ru.durnov.HtmlConvertService.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.durnov.HtmlConvertService.docx.DocxDocument;
import ru.durnov.HtmlConvertService.docx.OutputDocument;
import ru.durnov.HtmlConvertService.pdf.PdfOutputDocument;
import ru.durnov.HtmlConvertService.xlsx.XLSXDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class Request {
    private final String url;
    private final String type;
    private final String orientation;

    public Request(String url, String type, String orientation) {
        this.url = url;
        this.type = type;
        this.orientation = orientation;
    }

    public String fileName(){
        return "/tmp/" + new File(this.url).getName().replace(".html", "") + "." + this.type;
    }

    public Response response(){
        return new Response(fileName());
    }

    public OutputDocument document() throws IOException {
        if (this.type.equals("xlsx")) {
            log.info("return new XLSXDocumnet");
            return new XLSXDocument(url, fileName(), new XSSFWorkbook());
        }
        if (this.type.equals("docx")) {
            log.info("return new DocxDocument");
            return new DocxDocument(Files.readString(Path.of(url)), fileName());
        }
        log.info("return PdfOutputDocument");
        return new PdfOutputDocument(this.url, this.fileName());
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", orientation='" + orientation + '\'' +
                '}';
    }
}
