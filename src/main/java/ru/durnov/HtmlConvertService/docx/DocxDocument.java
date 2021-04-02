package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.altchunk.XWPFDocumentWithPackagePart;
import ru.durnov.HtmlConvertService.text.ElementFactory;
import ru.durnov.HtmlConvertService.style.CTDocumentWithPageSize;
import ru.durnov.HtmlConvertService.style.DocxPage;
import ru.durnov.HtmlConvertService.style.Page;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DocxDocument implements OutputDocument{
    private final String htmlContent;
    private final String pathToOutputFile;
    private final Page page;
    private XWPFDocument xwpfDocument;


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
    public void save() throws IOException, InvalidFormatException {
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        Document document = Jsoup.parse(htmlContent);
        document.body().childNodes().forEach(node -> {
            if (node.getClass() == Element.class){
                Element element = (Element) node;
                try {
                    new ElementFactory(element, xwpfDocument)
                            .elementByName()
                            .addToXWPFDocument();
                } catch (IOException | InvalidFormatException e) {
                    e.printStackTrace();
                }

            }
        });
        //this.xwpfDocument = new XWPFDocumentWithPackagePart(htmlContent, xwpfDocument).xwpfDocument();
        xwpfDocument.write(new FileOutputStream(pathToOutputFile));
    }
}
