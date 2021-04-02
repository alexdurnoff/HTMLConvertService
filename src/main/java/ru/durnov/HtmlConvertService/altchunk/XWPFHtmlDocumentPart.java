package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Класс представляет вложение в XWPFDocument
 */
public class XWPFHtmlDocumentPart extends POIXMLDocumentPart {
    private final String content;
    private final String id;

    public XWPFHtmlDocumentPart(PackagePart part, Path sourceFilePath, String id)
            throws InvalidFormatException, IOException {
        super(part);
        this.content = Files.readString(sourceFilePath);
        this.id = id;
    }

    public XWPFHtmlDocumentPart(PackagePart part, String content, String id) throws InvalidFormatException, IOException {
       super(part);
       this.content = content;
       this.id = id;
    }

    @Override
    protected void commit() throws IOException {
            PackagePart part = getPackagePart();
            OutputStream outputStream = part.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            writer.write(content);
            writer.close();
            outputStream.close();
    }

}
