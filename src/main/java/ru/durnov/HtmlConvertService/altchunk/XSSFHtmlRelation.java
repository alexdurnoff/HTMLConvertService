package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.ooxml.POIXMLRelation;

public class XSSFHtmlRelation extends POIXMLRelation {

    protected XSSFHtmlRelation(){
        super(
                "text/html",
                "http://schemas.openxmlformats.org/officeDocument/2006/relationships/aFChunk",
                "xl/worksheets/htmlDoc#.html"
        );
    }

}
