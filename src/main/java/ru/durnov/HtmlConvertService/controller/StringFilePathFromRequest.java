package ru.durnov.HtmlConvertService.controller;

import ru.durnov.HtmlConvertService.entity.Request;

import java.io.File;

/**
 * Класс получает Request и возвращает путь к конечному файлу в виде строки.
 */
public class StringFilePathFromRequest {
    private final Request request;

    public StringFilePathFromRequest(Request request) {
        this.request = request;
    }

    public String filePath() {
        return null;
    }
}
