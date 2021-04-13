package ru.durnov.HtmlConvertService.text;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

import java.io.IOException;
import java.util.List;

@Slf4j
public class LabelParagraphElement implements DocxParagraphElement {
    private final Element element;
    private final XWPFDocument xwpfDocument;

    public LabelParagraphElement(Element element, XWPFDocument xwpfDocument) {
        this.element = element;
        this.xwpfDocument = xwpfDocument;
    }

    @Override
    public void addToXWPFDocument() throws IOException, InvalidFormatException {
        List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();
        XWPFParagraph xwpfParagraph = paragraphs.get(paragraphs.size() - 1);
        List<XWPFRun> runs = xwpfParagraph.getRuns();
        XWPFRun xwpfRun = runs.get(runs.size() - 1);
        log.debug(xwpfRun.text());
        log.debug(element.ownText());
        log.debug(xwpfRun.text() + " " + element.ownText());
        xwpfRun.setText(" " + element.ownText());
    }
}
