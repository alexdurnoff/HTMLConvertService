package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ru.durnov.HtmlConvertService.node.ElementFactory;

import java.io.FileOutputStream;
import java.io.IOException;

public class DocxDocument implements OutputDocument{
    private final String htmlContent;
    private final String pathToOutputFile;


    public DocxDocument(String htmlContent, String pathToOutputFile) {
        this.htmlContent = htmlContent;
        this.pathToOutputFile = pathToOutputFile;
    }


    @Override
    public void save() throws IOException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        Document document = Jsoup.parse(htmlContent);
        document.body()
                .getAllElements()
                .forEach(element -> {
                    new ElementFactory(element, xwpfDocument)
                            .elementByName()
                            .addToXWPFDocument();
                });
        xwpfDocument.write(new FileOutputStream(pathToOutputFile));
    }
}
