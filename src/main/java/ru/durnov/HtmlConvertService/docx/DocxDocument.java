package ru.durnov.HtmlConvertService.docx;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.text.ElementFactory;
import ru.durnov.HtmlConvertService.style.CTDocumentWithPageSize;
import ru.durnov.HtmlConvertService.style.DocxPage;
import ru.durnov.HtmlConvertService.style.Page;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
public class DocxDocument implements OutputDocument{
    private final String htmlContent;
    private final String pathToOutputFile;
    private final Page page;
    private final XWPFDocument xwpfDocument;


    public DocxDocument(String htmlContent, String pathToOutputFile) {
        this.htmlContent = htmlContent;
        this.pathToOutputFile = pathToOutputFile;
        this.page = new DocxPage("landscape");
        this.xwpfDocument = new XWPFDocument();
    }

    public DocxDocument(String htmlContent, String pathToOutputFile, Page page) {
        this.htmlContent = htmlContent;
        this.pathToOutputFile = pathToOutputFile;
        this.page = page;
        this.xwpfDocument = new XWPFDocument();
    }

    public DocxDocument(String htmlContent, String pathToOutputFile, String orientation){
        this.htmlContent = htmlContent;
        this.pathToOutputFile = pathToOutputFile;
        this.page = new DocxPage(orientation);
        this.xwpfDocument = new XWPFDocument();
    }

    @Override
    public void save() throws IOException, InvalidFormatException {
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
        Document document = Jsoup.parse(htmlContent);
        List<Node> nodeList = document.body().childNodes();
        for (Node node : nodeList) {
            if (node.getClass() == Element.class){
                Element element = (Element) node;
                try {
                    new ElementFactory(element, xwpfDocument)
                            .elementByName()
                            .addToXWPFDocument();
                } catch (IOException exception) {
                    log.error(exception.getMessage());
                    throw new IOException("Ошибка чтения-записи при обработке тэга " +
                            element.html());
                } catch (InvalidFormatException exception) {
                    log.error(exception.getMessage());
                    throw new InvalidFormatException("Некорректный html-формат тэга " +
                            element.html());
                }
            }

        }
        try(FileOutputStream fileOutputStream = new FileOutputStream(pathToOutputFile)) {
            xwpfDocument.write(fileOutputStream);
        } catch (IOException exception) {
            log.error("Ошибка при сохранении docx-файла " + pathToOutputFile);
            throw new IOException("Ошибка при сохранении docx-файла " + pathToOutputFile);
        }
    }
}
