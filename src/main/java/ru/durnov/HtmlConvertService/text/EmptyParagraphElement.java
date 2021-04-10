package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/**
 * Пустая имплементация, которая ничего не пишет в документ,
 * чтобы не плодить null и NPE.
 */
public class EmptyParagraphElement implements DocxParagraphElement {
    @Override
    public void addToXWPFDocument() {

    }

}
