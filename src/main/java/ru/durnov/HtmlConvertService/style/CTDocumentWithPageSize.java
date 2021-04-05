package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPageMarImpl;

import java.math.BigInteger;

/**
 * Настраивает размер страницы в docx-документе.
 */
public class CTDocumentWithPageSize {
    private final XWPFDocument xwpfDocument;
    private final Page page;

    public CTDocumentWithPageSize(XWPFDocument xwpfDocument, Page page) {
        this.xwpfDocument = xwpfDocument;
        this.page = page;
    }

    public void setUpPageSize(){
        int height = page.heigth();
        int width = page.width();
        CTDocument1 ctDocument1 = xwpfDocument.getDocument();
        CTBody ctBody = ctDocument1.getBody();
        CTSectPr sectPr = ctBody.addNewSectPr();
        if (sectPr.isSetPgSz()) sectPr.addNewPgSz();
        CTPageSz pageSz = sectPr.addNewPgSz();
        pageSz.setH(BigInteger.valueOf(height* 20L));
        pageSz.setW(BigInteger.valueOf(width* 20L));
        CTPageMar pageMar = sectPr.addNewPgMar();
        pageMar.setLeft(BigInteger.valueOf(300));
        pageMar.setRight(BigInteger.valueOf(300));
    }
}
