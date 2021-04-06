package ru.durnov.HtmlConvertService.controller;


import ru.durnov.HtmlConvertService.docx.OutputDocument;
import ru.durnov.HtmlConvertService.entity.Request;


/**
 * Класс получает Request и возвращает соответствующий
 * OutPutDocument.
 */
public class OutPutDocumentFromRequest {
    private final Request request;


    public OutPutDocumentFromRequest(Request request) {
        this.request = request;
    }

    public OutputDocument document() {
        return null;
    }
}
