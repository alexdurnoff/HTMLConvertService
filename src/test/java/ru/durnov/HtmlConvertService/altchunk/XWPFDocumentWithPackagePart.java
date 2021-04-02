package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import ru.durnov.HtmlConvertService.style.CTDocumentWithPageSize;
import ru.durnov.HtmlConvertService.style.Page;

import java.nio.file.Path;

/**
 * XWPFDocument с вложенной частью.
 */
public class XWPFDocumentWithPackagePart {
    private final String htmlSourcePath;
    private final String id;
    private XWPFDocument xwpfDocument;

    public XWPFDocumentWithPackagePart(String htmlSourcePath) {
        this.htmlSourcePath = htmlSourcePath;
        this.id = Path.of(htmlSourcePath).getFileName().toString();
        this.xwpfDocument = new XWPFDocument();
    }

    public XWPFDocumentWithPackagePart(String htmlSourcePath, Page page){
        this(htmlSourcePath);
        new CTDocumentWithPageSize(xwpfDocument,page).setUpPageSize();
    }

    public XWPFDocumentWithPackagePart(String htmlSourcePath, XWPFDocument xwpfDocument){
        this.htmlSourcePath = htmlSourcePath;
        this.id = Path.of(htmlSourcePath).getFileName().toString();
        this.xwpfDocument = xwpfDocument;
    }

    public XWPFDocument xwpfDocument() throws InvalidFormatException {
        XWPFHtmlDocumentPart xwpfHtmlDocumentPart = new XWPFHtmlDocumentPart(
                new PackagePartWithPartName(
                        id,
                        xwpfDocument.getPackage()
                ).packagePart(),
                htmlSourcePath,
                id
        );
        xwpfDocument.addRelation(id, new XWPFHtmlRelation(), xwpfHtmlDocumentPart);
        xwpfDocument.getDocument().getBody().addNewAltChunk().setId(id);
        return xwpfDocument;
    }
}
