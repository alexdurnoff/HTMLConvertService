package ru.durnov.HtmlConvertService.text;

import com.itextpdf.styledxmlparser.jsoup.Jsoup;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.docx.DocxDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class aTagTest {

    @Test
    public void testStructure(){
        String source = "    <a class=\"имя_класса\" target=\"параметр\" title=\"подсказка\" href=\"http://yandex.ru\">яндекс</a>";
        Jsoup.parse(source).body().getAllElements().forEach(element -> {
            System.out.println("nodeName is " + element.nodeName());
            System.out.println("text is " + element.text());
            element.attributes().forEach(attribute -> {
                System.out.println(attribute.getKey() + "=" + attribute.getValue());
            });
            if (element.nodeName().equals("a")) {
                System.out.println("invoke href : " + element.attributes().get("href"));
            }

        });
    }

    @Test
    public void testCreateSimpleDocxDocumentWithHyperlink() throws IOException, InvalidFormatException {
        String source = "    <a class=\"имя_класса\" target=\"параметр\" title=\"подсказка\" href=\"http://yandex.ru\">яндекс</a>";
        DocxDocument document = new DocxDocument(source, "Test/docx/testHyperLink.docx");
        document.save();
    }
}
