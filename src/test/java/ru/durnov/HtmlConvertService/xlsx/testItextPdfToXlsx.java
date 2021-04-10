package ru.durnov.HtmlConvertService.xlsx;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

public class testItextPdfToXlsx {

    @Test
    public void test1() throws IOException {
        PdfReader pdfReader = new PdfReader("Test/pdf/1.pdf");
        PdfDictionary pageN = pdfReader.getPageN(1);
        Set<PdfName> keys = pageN.getKeys();
        keys.forEach(key -> System.out.println(key + ":" + pageN.get(key)));

    }
}
