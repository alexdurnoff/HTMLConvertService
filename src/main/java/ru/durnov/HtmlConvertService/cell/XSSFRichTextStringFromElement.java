package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class XSSFRichTextStringFromElement {
    private final Element element;
    private final XSSFCell xssfCell;
    private final XSSFFont xssfFont;

    public XSSFRichTextStringFromElement(Element element, XSSFCell xssfCell, XSSFFont xssfFont) {
        this.element = element;
        this.xssfCell = xssfCell;
        this.xssfFont = xssfFont;
    }

    public XSSFRichTextStringFromElement(Element element, XSSFCell xssfCell){
        this.element = element;
        this.xssfCell = xssfCell;
        this.xssfFont = xssfCell.getSheet().getWorkbook().createFont();
    }

    public XSSFRichTextString xssfRichTextString(){
        XSSFFont font = this.xssfFont;
        XSSFRichTextString xssfRichTextString = new XSSFRichTextString();
        Elements allElements = element.getAllElements();
        for (Element element1 : allElements) {
            xssfRichTextString.append(
                    new OwnTextFromElement(
                            element1
                    ).text(),
                    new XSSFFontFromElement(
                            element1,
                            font,
                            xssfCell
                    ).xssfFont());
        }
        return xssfRichTextString;
    }
}
