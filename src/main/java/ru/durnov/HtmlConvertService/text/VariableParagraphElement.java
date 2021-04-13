package ru.durnov.HtmlConvertService.text;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.text.AbstractDocument;
import java.io.IOException;

@Slf4j
public class VariableParagraphElement implements DocxParagraphElement {
    private final Element element;
    private final XWPFDocument xwpfDocument;

    public VariableParagraphElement(Element element, XWPFDocument xwpfDocument) {
        this.element = element;
        this.xwpfDocument = xwpfDocument;
    }

    @Override
    public void addToXWPFDocument() throws IOException, InvalidFormatException {
        Elements labels = this.element.getElementsByTag("label");
        for (Element label : labels) {
            new LabelParagraphElement(label, xwpfDocument).addToXWPFDocument();
        }
    }
}
