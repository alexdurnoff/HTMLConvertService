package ru.durnov.HtmlConvertService;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import com.itextpdf.styledxmlparser.jsoup.Jsoup;
import com.itextpdf.styledxmlparser.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class TestHtmlToPdfLibrearies {

    @Test
    public void test2() throws IOException {
        com.itextpdf.kernel.pdf.PdfWriter pdfWriter = new PdfWriter(new File("Test/pdf/1.pdf"));
        com.itextpdf.kernel.pdf.PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(new PageSize(1920,1080));
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(MediaType.PRINT, 1920, 1080));
        HtmlConverter.convertToPdf(
                new FileInputStream(
                        "Test/1.html"
                )
                ,pdfDocument
        );
    }

    @Test
    public void test3() throws IOException {
        com.itextpdf.kernel.pdf.PdfWriter pdfWriter = new PdfWriter(new File("Test/pdf/2.pdf"));
        com.itextpdf.kernel.pdf.PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(new PageSize(1920,1080));
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(MediaType.PRINT, 1920, 1080));
        HtmlConverter.convertToPdf(
                new FileInputStream(
                        "Test/2.html"
                )
                ,pdfDocument
        );
    }

    @Test
    public  void test4() throws IOException {
        com.itextpdf.kernel.pdf.PdfWriter pdfWriter = new PdfWriter(new File("Test/pdf/3.pdf"));
        com.itextpdf.kernel.pdf.PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(new PageSize(1920,1080));
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(MediaType.PRINT, 1920, 1080));
        HtmlConverter.convertToPdf(
                new FileInputStream(
                        "Test/3.html"
                )
                ,pdfDocument
        );
    }

    @Test
    public void test5() throws IOException {
        com.itextpdf.kernel.pdf.PdfWriter pdfWriter = new PdfWriter(new File("Test/pdf/4.pdf"));
        com.itextpdf.kernel.pdf.PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(new PageSize(1920,1080));
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(MediaType.PRINT, 1920, 1080));
        HtmlConverter.convertToPdf(
                new FileInputStream(
                        "Test/4.html"
                )
                ,pdfDocument
        );
    }

    @Test
    public void testItextJsoup() throws IOException {

    }
}
