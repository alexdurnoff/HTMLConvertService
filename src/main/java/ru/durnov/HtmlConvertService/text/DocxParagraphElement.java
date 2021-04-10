package ru.durnov.HtmlConvertService.text;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.io.IOException;

/**
 * Интерфейс для записи элементов в
 * docx-файл.
 */
public interface DocxParagraphElement {
    void addToXWPFDocument() throws IOException, InvalidFormatException;

}
