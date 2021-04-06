package ru.durnov.HtmlConvertService.pdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import ru.durnov.HtmlConvertService.docx.OutputDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PdfOutputDocument implements OutputDocument {
    private final String sourceFile;
    private final String outPutFile;

    public PdfOutputDocument(String sourceFile, String outPutFile) {
        this.sourceFile = sourceFile;
        this.outPutFile = outPutFile;
    }

    @Override
    public void save() throws IOException, InvalidFormatException {
        com.itextpdf.kernel.pdf.PdfWriter pdfWriter = new PdfWriter(new File(outPutFile));
        com.itextpdf.kernel.pdf.PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(new PageSize(1920,1080));
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(MediaType.PRINT, 1920, 1080));
        HtmlConverter.convertToPdf(
                new FileInputStream(
                        sourceFile
                )
                ,pdfDocument
        );
    }


}
