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
    private final String sourceFilePath;
    private final String id;

    public XWPFHtmlDocumentPart(PackagePart part, String sourceFilePath, String id)
            throws InvalidFormatException {
        super(part);
        this.sourceFilePath = sourceFilePath;
        this.id = id;
    }





    public XWPFHtmlDocumentPart(PackagePart part, String sourceFilePath) throws InvalidFormatException {
       super(part);
       this.sourceFilePath = sourceFilePath;
       this.id = Path.of(sourceFilePath).getFileName().toString();
    }




    @Override
    protected void commit() throws IOException {
            PackagePart part = getPackagePart();
            String content = Files.readString(Path.of(sourceFilePath));
            OutputStream outputStream = part.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            writer.write(content);
            writer.close();
            outputStream.close();
    }

}
