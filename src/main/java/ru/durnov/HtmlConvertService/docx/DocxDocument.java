package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.node.ElementFactory;
import ru.durnov.HtmlConvertService.style.CTDocumentWithPageSize;
import ru.durnov.HtmlConvertService.style.DocxPage;
import ru.durnov.HtmlConvertService.style.Page;

import java.io.FileOutputStream;
import java.io.IOException;

public class DocxDocument implements OutputDocument{
    private final String htmlContent;
    private final String pathToOutputFile;
    private final Page page;
    private final XWPFDocument xwpfDocument;


    public DocxDocument(String htmlContent, String pathToOutputFile) {
        this.htmlContent = htmlContent;
        this.pathToOutputFile = pathToOutputFile;
        this.page = new DocxPage("landshaft");
        this.xwpfDocument = new XWPFDocument();
    }

    public DocxDocument(String htmlContent, String pathToOutputFile, Page page) {
        this.htmlContent = htmlContent;
        this.pathToOutputFile = pathToOutputFile;
        this.page = page;
        this.xwpfDocument = new XWPFDocument();
    }

    @Override
    public void save() throws IOException {
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        Document document = Jsoup.parse(htmlContent);
        document.body().childNodes().forEach(node -> {
            if (node.getClass() == Element.class){
                Element element = (Element) node;
                new ElementFactory(element, xwpfDocument)
                        .elementByName()
                        .addToXWPFDocument();
            }
        });
        xwpfDocument.write(new FileOutputStream(pathToOutputFile));
    }
}
