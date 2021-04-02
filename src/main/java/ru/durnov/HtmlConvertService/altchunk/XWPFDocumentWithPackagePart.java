package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import ru.durnov.HtmlConvertService.style.CTDocumentWithPageSize;
import ru.durnov.HtmlConvertService.style.Page;

import java.io.IOException;

/**
 * XWPFDocument с вложенной частью.
 */
public class XWPFDocumentWithPackagePart {
    private final String content;
    private final String id;
    private final XWPFDocument xwpfDocument;

    public XWPFDocumentWithPackagePart(String content) {
        this.content = content;
        this.id = "htmlDoc1.html";
        this.xwpfDocument = new XWPFDocument();
    }

    public XWPFDocumentWithPackagePart(String content, Page page){
        this(content);
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
    }

    public XWPFDocumentWithPackagePart(String content, XWPFDocument xwpfDocument){
        this.content = content;
        int number = 1;
        try {
            number = xwpfDocument.getPackage().getParts().size() + 1;
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        this.id = "htmlDoc" + number + ".html";
        this.xwpfDocument = xwpfDocument;
    }

    public XWPFDocumentWithPackagePart(String content, XWPFDocument xwpfDocument, int idNumber){
        this.content = content;
        this.xwpfDocument = xwpfDocument;
        this.id = "htmlDoc" + idNumber + ".html";
    }

    public XWPFDocument xwpfDocument() throws InvalidFormatException, IOException {
        XWPFHtmlDocumentPart xwpfHtmlDocumentPart = new XWPFHtmlDocumentPart(
                new PackagePartWithPartName(
                        id,
                        xwpfDocument.getPackage()
                ).packagePart(),
                content,
                id
        );
        xwpfDocument.addRelation(id, new XWPFHtmlRelation(), xwpfHtmlDocumentPart);
        xwpfDocument.getDocument().getBody().addNewAltChunk().setId(id);
        return xwpfDocument;
    }
}
