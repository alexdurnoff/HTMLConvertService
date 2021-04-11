package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.ooxml.POIXMLRelation;

public class XSSFHtmlRelation extends POIXMLRelation {

    public XSSFHtmlRelation(){
        super(
                "text/html",
                "http://schemas.openxmlformats.org/officeDocument/2006/relationships/aFChunk",
                "/workbook/htmlDoc#.html");
    }
}
