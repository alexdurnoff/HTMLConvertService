package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.ooxml.POIXMLRelation;

public class XWPFHtmlRelation extends POIXMLRelation {

    protected XWPFHtmlRelation() {
        super(
                "text/html",
                "http://schemas.openxmlformats.org/officeDocument/2006/relationships/aFChunk",
                "/word/htmlDoc#.html");
    }
}
