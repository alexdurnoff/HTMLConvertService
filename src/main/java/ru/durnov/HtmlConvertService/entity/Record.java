package ru.durnov.HtmlConvertService.entity;

import ru.durnov.HtmlConvertService.docx.OutputDocument;

public class Record {
    private final String id;
    private final String htmlContent;

    public Record(String id, String htmlContent) {
        this.id = id;
        this.htmlContent = htmlContent;
    }


}
