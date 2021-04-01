package ru.durnov.HtmlConvertService;

import com.itextpdf.styledxmlparser.jsoup.Jsoup;
import com.itextpdf.styledxmlparser.jsoup.nodes.*;
import com.itextpdf.styledxmlparser.jsoup.select.Elements;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsoupTest {

    @Test
    public void testParsing1HTML() throws IOException {
        Document document = Jsoup.parse(Files.readString(Path.of("Test/1.html")));
        parseDocumentStructure(document);
    }

    private void parseDocumentStructure(Document document) {
        Element body = document.body();
        List<Node> nodes = body.childNodes();
        for (int i = 0; i < nodes.size(); i++){
            Node node = nodes.get(i);
            System.out.println("Node name = " + node.nodeName());
            printNodeStructure(node);
        }
    }

    private void printNodeStructure(Node node){
        System.out.println("Node -" + node.nodeName() + " is child -" + node.parent().nodeName());
        Attributes attributes = node.attributes();
        List<Attribute> attributeList = attributes.asList();
        attributeList.forEach(a -> {
            System.out.println(a.getKey() + "=" + a.getValue());
        });
        node.childNodes().forEach(this::printNodeStructure);
    }

    @Test
    public void testParsing2HTML() throws IOException {
        Document document = Jsoup.parse(Files.readString(Path.of("Test/2.html")));
        parseDocumentStructure(document);
    }

    @Test
    public void testParsing3HTML() throws IOException {
        Document document = Jsoup.parse(Files.readString(Path.of("Test/3.html")));
        parseDocumentStructure(document);
    }

    @Test
    public void testParsing4HTML() throws IOException {
        Document document = Jsoup.parse(Files.readString(Path.of("Test/4.html")));
        parseDocumentStructure(document);
    }


    @Test
    public void testWritePNodeToXWPFDocument() throws IOException {
        XWPFDocument document = new XWPFDocument();
        List<Node> pNodeList = pNodeListFrom2HTML();
        System.out.println(pNodeList.size());
        XWPFParagraph paragraph = document.createParagraph();
        for (Node node : pNodeList){
            XWPFRun run = paragraph.createRun();
            run.setText(textFromPNode(node));
        }
        document.write(new FileOutputStream("Test/docx/pNodeWrite1.docx"));
    }

    private String textFromPNode(Node node) {
       StringBuilder stringBuilder = new StringBuilder();
        String text = node.attributes().get("text");
        if (text != null) stringBuilder.append(text);
        node.childNodes().forEach(node1 -> {
            stringBuilder.append(textFromPNode(node1));
        });
        return stringBuilder.toString();
    }

    private List<Node> pNodeListFrom2HTML() throws IOException {
        List<Node> pNodeList= new ArrayList<>();
        Document document = Jsoup.parse(Files.readString(Path.of("Test/4.html")));
        Element body = document.body();
        List<Node> nodes = body.childNodes();
        for (int i = 0; i < nodes.size(); i++){
            Node node = nodes.get(i);
            if (node.nodeName().equals("p")) pNodeList.add(node);
        }
        return pNodeList;
    }

    @Test
    public void parsePElementStructure() throws IOException {
        Document document = Jsoup.parse(Files.readString(Path.of("Test/1.html")));
        Element body = document.body();
           body.select("p").forEach(element -> {
               System.out.println(element.toString());
               System.out.println("-----------------------------------------------");
           });
    }


}
