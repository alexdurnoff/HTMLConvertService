package ru.durnov.HtmlConvertService.pdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import lombok.extern.slf4j.Slf4j;
import ru.durnov.HtmlConvertService.docx.OutputDocument;
import ru.durnov.HtmlConvertService.style.Page;
import ru.durnov.HtmlConvertService.style.PdfPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class PdfOutputDocument implements OutputDocument {
    private final String sourceFile;
    private final String outPutFile;
    private final Page page;

    public PdfOutputDocument(String sourceFile, String outPutFile) {
        this.sourceFile = sourceFile;
        this.outPutFile = outPutFile;
        this.page = new PdfPage("landscape");
    }

    public PdfOutputDocument(String sourceFile, String outPutFile, String orientation){
        this.sourceFile = sourceFile;
        this.outPutFile = outPutFile;
        this.page = new PdfPage(orientation);
    }

    @Override
    public void save() throws IOException {
        PdfDocument pdfDocument = null;
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile)) {
            PdfWriter pdfWriter = new PdfWriter(new File(outPutFile));
            pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(
                    new PageSize(
                            page.width(),
                            page.height()
                    )
            );
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(MediaType.PRINT, 1920, 1080));
            HtmlConverter.convertToPdf(
                    fileInputStream
                    ,pdfDocument
            );
        } catch (IOException exception) {
            log.error("Ошибка при сохранении pdf-файла " + outPutFile);
            throw new IOException("Ошибка при сохранении pdf-файла " + outPutFile);
        } finally {
            if (pdfDocument != null) pdfDocument.close();
        }
    }


}
