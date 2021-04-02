package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OutputDocument {
    void save() throws IOException, InvalidFormatException;
}
