package ru.durnov.HtmlConvertService.text;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

/**
 * Интерфейс для записи элементов в
 * docx-файл.
 */
public interface DocxParagraphElement {
    void addToXWPFDocument() throws IOException, InvalidFormatException;
}
